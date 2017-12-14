package scene;

import javafx.application.Platform;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
//	public static final Font bodyFont = Font.font("Monospace" ,20);
	private static Font bodyFont = Font.loadFont("file:res/font/SPACEBAR.ttf",10);
	private Canvas bgCanvas = new Canvas(SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
	private Canvas replayBtn;
	private Canvas homeBtn;
	private Canvas field, gameOverLabel, result;
	
	private int state = 0;
	private Canvas bgWindow, exitMenu, yesBtn, noBtn;
	
	public GameOver() {
		
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
		showResult(result, 0, 0, 0);
		
		field = new Canvas(300,300);
		field.setOpacity(0.5);
		GraphicsContext gcSth = field.getGraphicsContext2D();
		gcSth.setFill(Color.WHITE);
		gcSth.fillRoundRect(1, 1, 300-2, 300-2, 20, 20);
		
		
		changeCenter(result, (SceneManager.SCENE_WIDTH-300)/2, 150);
		changeCenter(field, (SceneManager.SCENE_WIDTH-300)/2, 150);
		getChildren().addAll(field,result);
		
		replayBtn = drawButton(ResLoader.ReplayBtn1);	
		replayBtn.setFocusTraversable(true);
		addCanvasEvents(replayBtn, "Replay", ResLoader.ReplayBtn1, ResLoader.ReplayBtn2);
		
		getChildren().add(replayBtn);
		changeCenter(replayBtn, (SceneManager.SCENE_WIDTH-BTN_WIDTH)/4, 475);
		
		homeBtn = drawButton(ResLoader.HomeBtn1);	
		addCanvasEvents(homeBtn, "Home", ResLoader.HomeBtn1, ResLoader.HomeBtn2);
		
		getChildren().add(homeBtn);
		changeCenter(homeBtn, 3*(SceneManager.SCENE_WIDTH-BTN_WIDTH)/4, 475);
		
		bgWindow = new Canvas(SceneManager.SCENE_WIDTH/2, SceneManager.SCENE_HEIGHT/5);
		bgWindow.setVisible(false);
		
		exitMenu = new Canvas(SceneManager.SCENE_WIDTH/2, SceneManager.SCENE_HEIGHT/5);
		exitMenu.setVisible(false);

		yesBtn = new Canvas(SceneManager.SCENE_WIDTH/8, SceneManager.SCENE_HEIGHT/14);
		addCanvasEvents(yesBtn, "Yes");
		yesBtn.setVisible(false);
		
		yesBtn = new Canvas(SceneManager.SCENE_WIDTH/8, SceneManager.SCENE_HEIGHT/14);
		addCanvasEvents(yesBtn, "Yes");
		yesBtn.setVisible(false);

		noBtn = new Canvas(SceneManager.SCENE_WIDTH/8, SceneManager.SCENE_HEIGHT/14);
		addCanvasEvents(noBtn, "No");
		noBtn.setVisible(false);
		
		drawPauseWindow(bgWindow, exitMenu, yesBtn, noBtn);
		getChildren().addAll(bgWindow, exitMenu, yesBtn, noBtn);
		
		
	}
	
	private void changeCenter(Canvas canvas,double x, double y) {
		canvas.setTranslateX(x);
		canvas.setTranslateY(y);
	}
	
	private void drawPauseWindow(Canvas bgWindow, Canvas exitMenu, Canvas yesBtn, Canvas noBtn) {
//		bgWindow.setOpacity(0.8);
		
		GraphicsContext gc = bgWindow.getGraphicsContext2D();
		GraphicsContext gc2 = exitMenu.getGraphicsContext2D();
		GraphicsContext gc3 = yesBtn.getGraphicsContext2D();
		GraphicsContext gc4 = noBtn.getGraphicsContext2D();

		bgWindow.setTranslateX((SceneManager.SCENE_WIDTH-SceneManager.SCENE_WIDTH/2)/2);
		bgWindow.setTranslateY((SceneManager.SCENE_HEIGHT-SceneManager.SCENE_HEIGHT/5)/2);
		exitMenu.setTranslateX((SceneManager.SCENE_WIDTH-SceneManager.SCENE_WIDTH/2)/2);
		exitMenu.setTranslateY((SceneManager.SCENE_HEIGHT-SceneManager.SCENE_HEIGHT/5)/2);
		yesBtn.setTranslateX((SceneManager.SCENE_WIDTH-SceneManager.SCENE_WIDTH/2)/2+15);
		yesBtn.setTranslateY((SceneManager.SCENE_HEIGHT-SceneManager.SCENE_HEIGHT/5)/2+65);
		noBtn.setTranslateX((SceneManager.SCENE_WIDTH-SceneManager.SCENE_WIDTH/2)/2+SceneManager.SCENE_WIDTH/2-SceneManager.SCENE_WIDTH/8-15);
		noBtn.setTranslateY((SceneManager.SCENE_HEIGHT-SceneManager.SCENE_HEIGHT/5)/2+65);
			
			gc.setFill(Color.WHITE);
			gc.setLineWidth(5);
			gc.fillRoundRect(2.5, 2.5, SceneManager.SCENE_WIDTH/2-5, SceneManager.SCENE_HEIGHT/5-5, 30, 30);
			
			gc2.setFill(Color.BLACK);
			gc2.setLineWidth(5);
			gc2.strokeRoundRect(2.5, 2.5, SceneManager.SCENE_WIDTH/2-5, SceneManager.SCENE_HEIGHT/5-5, 30, 30);
			gc2.setFill(Color.BLACK);
			gc2.setFont(bodyFont);
			gc2.setTextAlign(TextAlignment.CENTER);
			gc2.setTextBaseline(VPos.CENTER);
			gc2.fillText("EXIT", SceneManager.SCENE_WIDTH / 4, SceneManager.SCENE_HEIGHT / 10 - 20);
			
			gc3.setFill(Color.BLACK);
			gc3.fillRoundRect(0, 0, SceneManager.SCENE_WIDTH/8, SceneManager.SCENE_HEIGHT/14, 30, 30);
			gc3.setFill(Color.WHITE);
			gc3.setFont(bodyFont);
			gc3.setTextAlign(TextAlignment.CENTER);
			gc3.setTextBaseline(VPos.CENTER);
			gc3.fillText("YES", SceneManager.SCENE_WIDTH / 16, SceneManager.SCENE_HEIGHT / 28);
		
			gc4.setFill(Color.BLACK);
			gc4.fillRoundRect(0, 0, SceneManager.SCENE_WIDTH/8, SceneManager.SCENE_HEIGHT/14, 30, 30);
			gc4.setFill(Color.WHITE);
			gc4.setFont(bodyFont);
			gc4.setTextAlign(TextAlignment.CENTER);
			gc4.setTextBaseline(VPos.CENTER);
			gc4.fillText("NO", SceneManager.SCENE_WIDTH / 16, SceneManager.SCENE_HEIGHT / 28);
			
	}
	
	private void undrawPauseWindow(Canvas bgWindow, Canvas exitMenu, Canvas yesBtn, Canvas noBtn) {
		bgWindow.setVisible(false);
		exitMenu.setVisible(false);
		yesBtn.setVisible(false);
		noBtn.setVisible(false);
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
		
		canvas.setOnKeyPressed((KeyEvent e) -> {
			System.out.println(e.getCode().getName());
			if (e.getCode() == KeyCode.ESCAPE) {
				if(state==0) {
					this.bgWindow.setVisible(true);
					this.exitMenu.setVisible(true);
					this.yesBtn.setVisible(true);
					this.noBtn.setVisible(true);
					state++;
				}else {
					state = 0;
					undrawPauseWindow(bgWindow, exitMenu, yesBtn, noBtn);
				}
			}
		});
		
	}
	
	private void addCanvasEvents(Canvas canvas, String buttonName) {
		//TODO Fill Code
		canvas.setOnMouseClicked(new javafx.event.EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(buttonName=="Yes") Platform.exit();
				if(buttonName=="No") {
					state = 0;
					undrawPauseWindow(bgWindow, exitMenu, yesBtn, noBtn);
				}
			}
		});
		
	}
	
	private void showResult(Canvas canvas, int lvl, int damage, int maxBall) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		gc.setFill(Color.BLACK);
//		gc.setFont(bodyFont);
		gc.setFont(Font.font(30));
		gc.setTextAlign(TextAlignment.LEFT);
		gc.setTextBaseline(VPos.CENTER);
		gc.fillText("Level : "+lvl, 50, 50);
		gc.fillText("Damage : "+damage, 50, 100);
		gc.fillText("Max Ball : "+maxBall, 50, 150);
//		gc.setFill(Color.WHITE);
//		gc.fillRoundRect(20, 20, 100, 100, 20, 20);
//		gc.drawImage(ResLoader.MarsImg, 20, 20);
		
	}
	
}
