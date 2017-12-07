package scene;

import javafx.application.Platform;
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
	public static final Font headFont = Font.font("Monospace", FontWeight.BOLD,36);
	private Image BGImg;
	private Canvas BGCanvas = new Canvas(SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
	private Canvas ReplayBtn;
	private Canvas HomeBtn;
	private Image ReplayBtn1, ReplayBtn2, HomeBtn1, HomeBtn2;
	
	public GameOver() {
		
		BGImg = new Image("BG3.jpg");
		GraphicsContext gc = BGCanvas.getGraphicsContext2D();
		gc.drawImage(BGImg, 0, 0, SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
		getChildren().add(BGCanvas);
		
		Canvas GameOverLabel = new Canvas(400,200);
		GraphicsContext gc2 = GameOverLabel.getGraphicsContext2D();
		
		gc2.setFont(headFont);
		gc2.setFill(Color.WHITE);
		gc2.setTextBaseline(VPos.CENTER);
		gc2.setTextAlign(TextAlignment.CENTER);
		gc2.fillText("GAME OVER", 200, 100);
		
		changeCenter(GameOverLabel, 0, 0);
		getChildren().add(GameOverLabel);
		
		Canvas sth = new Canvas(300,300);
		sth.setOpacity(0.5);
		GraphicsContext gcSth = sth.getGraphicsContext2D();
		gcSth.setFill(Color.WHITE);
		gcSth.fillRoundRect(1, 1, 300-2, 300-2, 20, 20);
		changeCenter(sth, 50, 150);
		getChildren().add(sth);
		
		ReplayBtn1 = new Image("ReplayBtn1.png");
		ReplayBtn2 = new Image("ReplayBtn2.png");
		ReplayBtn = drawButton(ReplayBtn1);	
		addCanvasEvents(ReplayBtn, "Replay", ReplayBtn1, ReplayBtn2);
		
		getChildren().add(ReplayBtn);
		changeCenter(ReplayBtn, 100, 475);
		
		HomeBtn1 = new Image("HomeBtn1.png");
		HomeBtn2 = new Image("HomeBtn2.png");
		HomeBtn = drawButton(HomeBtn1);	
		addCanvasEvents(HomeBtn, "Home", HomeBtn1, HomeBtn2);
		
		getChildren().add(HomeBtn);
		changeCenter(HomeBtn, 225, 475);
		
		
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
				Pane gameStage = new GameStage();
				if(buttonName=="Replay") SceneManager.gotoSceneOf(gameStage);
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
	
}
