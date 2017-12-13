package scene;

import javax.swing.GroupLayout.Alignment;

import javafx.application.Platform;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class GameOver extends Pane{
	
	private final double BTN_WIDTH = 75;
	private final double BTN_HEIGHT = 75;
	public static final Font headFont = Font.font("Monospace", FontWeight.BOLD,36);
	public static final Font bodyFont = Font.font("Monospace" ,20);
	private Canvas BGCanvas = new Canvas(SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
	private Canvas ReplayBtn;
	private Canvas HomeBtn;
	private Canvas field, gameOverLabel, result;
	
	public GameOver() {
		
		GraphicsContext gc = BGCanvas.getGraphicsContext2D();
		gc.drawImage(ResLoader.GameOverImg, 0, 0, SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
		getChildren().add(BGCanvas);
		
		gameOverLabel = new Canvas(SceneManager.SCENE_WIDTH,200);
		GraphicsContext gc2 = gameOverLabel.getGraphicsContext2D();
		
		gc2.setFont(headFont);
		gc2.setFill(Color.WHITE);
		gc2.setTextBaseline(VPos.CENTER);
		gc2.setTextAlign(TextAlignment.CENTER);
		gc2.fillText("GAME OVER", SceneManager.SCENE_WIDTH/2, 100);
		
		changeCenter(gameOverLabel, 0, 0);
		getChildren().add(gameOverLabel);
		
		result = new Canvas(300,300);
		showResult(result, 0, 0, 0);
		
		field = new Canvas(300,300);
		field.setOpacity(0.5);
		GraphicsContext gcSth = field.getGraphicsContext2D();
		gcSth.setFill(Color.WHITE);
		gcSth.fillRoundRect(1, 1, 300-2, 300-2, 20, 20);
		
		
		changeCenter(result, (SceneManager.SCENE_WIDTH-300)/2, 150);
		changeCenter(field, (SceneManager.SCENE_WIDTH-300)/2, 150);
		getChildren().addAll(field,result);
		
		ReplayBtn = drawButton(ResLoader.ReplayBtn1);	
		addCanvasEvents(ReplayBtn, "Replay", ResLoader.ReplayBtn1, ResLoader.ReplayBtn2);
		
		getChildren().add(ReplayBtn);
		changeCenter(ReplayBtn, (SceneManager.SCENE_WIDTH-BTN_WIDTH)/4, 475);
		
		HomeBtn = drawButton(ResLoader.HomeBtn1);	
		addCanvasEvents(HomeBtn, "Home", ResLoader.HomeBtn1, ResLoader.HomeBtn2);
		
		getChildren().add(HomeBtn);
		changeCenter(HomeBtn, 3*(SceneManager.SCENE_WIDTH-BTN_WIDTH)/4, 475);
		
		
	}
	
	public void changeCenter(Canvas canvas,double x, double y) {
		canvas.setTranslateX(x);
		canvas.setTranslateY(y);
	}
	
	private Canvas drawButton(Image img) {
		Canvas btn = new Canvas(BTN_WIDTH,BTN_HEIGHT);
		GraphicsContext gc = btn.getGraphicsContext2D();
		gc.drawImage(img, 0, 0, BTN_WIDTH,BTN_HEIGHT);
		
		return btn;
	}
	
	private void drawOnMouseEvent(Canvas canvas, Image img) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.drawImage(img, 0, 0, BTN_WIDTH,BTN_HEIGHT);
	}	
	
	private void addCanvasEvents(Canvas canvas, String buttonName, Image img1, Image img2) {
		//TODO Fill Code
		canvas.setOnMouseClicked(new javafx.event.EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Pane selectBall = new SelectBall();
				if(buttonName=="Replay") SceneManager.goToGameScene();
				if(buttonName=="Home") SceneManager.gotoMainMenu();
			}
		});
		
		canvas.setOnMouseEntered(new javafx.event.EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				drawOnMouseEvent(canvas, img2);
			}	
		});
		
		canvas.setOnMouseExited(new javafx.event.EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				drawOnMouseEvent(canvas, img1);
			}
			
		});
	}
	
	public void showResult(Canvas canvas, int lvl, int damage, int maxBall) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		gc.setFill(Color.BLACK);
		gc.setFont(bodyFont);
		gc.setTextAlign(TextAlignment.RIGHT);
		gc.setTextBaseline(VPos.CENTER);
		gc.fillText("Level : "+lvl, 280, 50);
		gc.fillText("Damage : "+damage, 280, 100);
		gc.fillText("Max Ball : "+maxBall, 280, 150);
		gc.setFill(Color.WHITE);
		gc.fillRoundRect(20, 20, 100, 100, 20, 20);
		gc.drawImage(ResLoader.MarsImg, 20, 20);
		
	}
	
}
