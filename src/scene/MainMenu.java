package scene;

import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MainMenu extends Pane {
	
	private final double BTN_WIDTH = 100;
	private final double BTN_HEIGHT = 100;
	public static final Font headFont = Font.loadFont("file:res/font/SPACEBAR.ttf",50);
	public static final Font bodyFont = Font.loadFont("file:res/font/SPACEBAR.ttf",10);
	private Canvas PlayBtn;
	private Canvas MenuBG = new Canvas(SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
	
	private Canvas bgWindow, exitMenu, yesBtn, noBtn;
	private int state = 0;
	
	public MainMenu() {
		super();
		
		GraphicsContext gc = MenuBG.getGraphicsContext2D();
		gc.drawImage(ResLoader.MenuImg, 0, 0, SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
		getChildren().add(MenuBG);
		
		Canvas MainLabel = new Canvas(SceneManager.SCENE_WIDTH,300);
		GraphicsContext gc2 = MainLabel.getGraphicsContext2D();
		
		gc2.setFont(headFont);
		gc2.setFill(Color.WHITE);
		gc2.setTextBaseline(VPos.CENTER);
		gc2.setTextAlign(TextAlignment.CENTER);
		gc2.fillText("LOST\nSTAR", SceneManager.SCENE_WIDTH/2, 150);
		gc2.strokeText("LOST\nSTAR", SceneManager.SCENE_WIDTH/2, 150);
		
		
		changeCenter(MainLabel, 0, 0);
		getChildren().add(MainLabel);
		
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


		PlayBtn = drawButton(ResLoader.PlayBtn1);	
		PlayBtn.setFocusTraversable(true);
		addCanvasEvents(PlayBtn, "Play", ResLoader.PlayBtn1, ResLoader.PlayBtn2);
		
		getChildren().add(PlayBtn);
		changeCenter(PlayBtn, (SceneManager.SCENE_WIDTH-BTN_WIDTH)/2, SceneManager.SCENE_HEIGHT/2);


		
	}
	
	public static void drawPauseWindow(Canvas bgWindow, Canvas exitMenu, Canvas yesBtn, Canvas noBtn) {
		bgWindow.setOpacity(0.5);
		
		GraphicsContext gc = bgWindow.getGraphicsContext2D();
		GraphicsContext gc2 = exitMenu.getGraphicsContext2D();
		GraphicsContext gc3 = yesBtn.getGraphicsContext2D();
		GraphicsContext gc4 = noBtn.getGraphicsContext2D();

		bgWindow.setTranslateX((SceneManager.SCENE_WIDTH-SceneManager.SCENE_WIDTH/2)/2);
		bgWindow.setTranslateY((SceneManager.SCENE_HEIGHT-SceneManager.SCENE_HEIGHT/5)/2);
		exitMenu.setTranslateX((SceneManager.SCENE_WIDTH-SceneManager.SCENE_WIDTH/2)/2);
		exitMenu.setTranslateY((SceneManager.SCENE_HEIGHT-SceneManager.SCENE_HEIGHT/5)/2);
		yesBtn.setTranslateX((SceneManager.SCENE_WIDTH-SceneManager.SCENE_WIDTH/2)/2+10);
		yesBtn.setTranslateY((SceneManager.SCENE_HEIGHT-SceneManager.SCENE_HEIGHT/5)/2+50);
		noBtn.setTranslateX((SceneManager.SCENE_WIDTH-SceneManager.SCENE_WIDTH/2)/2+SceneManager.SCENE_WIDTH/2-SceneManager.SCENE_WIDTH/8-10);
		noBtn.setTranslateY((SceneManager.SCENE_HEIGHT-SceneManager.SCENE_HEIGHT/5)/2+50);
			
			gc.setFill(Color.DARKGRAY);
			gc.fillRoundRect(0, 0, SceneManager.SCENE_WIDTH/2, SceneManager.SCENE_HEIGHT/5, 30, 30);
			
			gc2.setFill(Color.BLACK);
			gc2.strokeRoundRect(0, 0, SceneManager.SCENE_WIDTH/2, SceneManager.SCENE_HEIGHT/5, 30, 30);
			gc2.setFill(Color.WHITE);
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
	
	public static void undrawPauseWindow(Canvas bgWindow, Canvas exitMenu, Canvas yesBtn, Canvas noBtn) {
		bgWindow.setVisible(false);
		exitMenu.setVisible(false);
		yesBtn.setVisible(false);
		noBtn.setVisible(false);
	}
	

	public static Canvas drawButton(String name, double width, double height, double posX, double posY) {
		Canvas canvas = new Canvas(width, height);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		canvas.setTranslateX(posX);
		canvas.setTranslateY(posY);
			
			gc.setFill(Color.BLACK);
			gc.fillRoundRect(0, 0, width, height, 30, 30);
			gc.setFill(Color.WHITE);
			gc.setFont(bodyFont);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.setTextBaseline(VPos.CENTER);
			gc.fillText(name, width / 2, height / 2);

		return canvas;

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
				if(buttonName=="Play") SceneManager.gotoSceneOf(selectBall);
				
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
	
}
