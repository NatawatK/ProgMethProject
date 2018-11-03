package scene;

import javafx.geometry.VPos;
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
	private static Font headFont = Font.font("Monospace", FontWeight.BOLD,36);
	private static Font bodyFont = Font.font("Monospace", FontWeight.BOLD,24);
	private Canvas bgCanvas = new Canvas(SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
	private Canvas replayBtn;
	private Canvas homeBtn;
	private Canvas field, gameOverLabel, result;
	private int lvl;
	private int maxBall;
	
	public GameOver(int lvl, int maxBall) {
		
		this.lvl = lvl;
		this.maxBall = maxBall;
		
		GraphicsContext gc = bgCanvas.getGraphicsContext2D();
		gc.drawImage(ResLoader.GameOverImg, 0, 0, SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
		getChildren().add(bgCanvas);
		
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
		showResult(result);
		
		field = new Canvas(300,200);
		field.setOpacity(0.5);
		GraphicsContext gcSth = field.getGraphicsContext2D();
		gcSth.setFill(Color.WHITE);
		gcSth.fillRoundRect(1, 1, 300-2, 200-2, 20, 20);
		
		
		changeCenter(result, (SceneManager.SCENE_WIDTH-300)/2, 150);
		changeCenter(field, (SceneManager.SCENE_WIDTH-300)/2, 150);
		getChildren().addAll(field,result);
		
		replayBtn = drawButton(ResLoader.ReplayBtn1);	
		replayBtn.setFocusTraversable(true);
		addCanvasEvents(replayBtn, "Replay", ResLoader.ReplayBtn1, ResLoader.ReplayBtn2);
		
		getChildren().add(replayBtn);
		changeCenter(replayBtn, (SceneManager.SCENE_WIDTH-BTN_WIDTH)/4, 375);
		
		homeBtn = drawButton(ResLoader.HomeBtn1);	
		addCanvasEvents(homeBtn, "Home", ResLoader.HomeBtn1, ResLoader.HomeBtn2);
		
		getChildren().add(homeBtn);
		changeCenter(homeBtn, 3*(SceneManager.SCENE_WIDTH-BTN_WIDTH)/4, 375);
		
	}
	
	private void changeCenter(Canvas canvas,double x, double y) {
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
<<<<<<< HEAD
=======
				Pane selectBall = new SelectBall();
>>>>>>> 159751500d0efa0a1717de865e78087068b3e5bb
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
	
	private void showResult(Canvas canvas) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		gc.setFill(Color.BLACK);
		gc.setFont(bodyFont);
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.CENTER);
		gc.fillText("LEVEL",canvas.getWidth()/2, 25);
		gc.fillText(""+lvl, canvas.getWidth()/2, 75);
		gc.fillText("MAX BALL", canvas.getWidth()/2, 125);
		gc.fillText(""+maxBall, canvas.getWidth()/2, 175);
		
	}
	
}
