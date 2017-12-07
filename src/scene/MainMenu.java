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

public class MainMenu extends Pane {
	
	private final double BTN_WIDTH = 100;
	private final double BTN_HEIGHT = 100;
	public static final Font headFont = Font.loadFont("file:res/fonts/SPACEBAR.ttf",50);
	private Canvas PlayBtn;
	private Canvas QuitBtn;
	private Canvas MenuBG = new Canvas(SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
	private Image MenuImg, PlayBtn1, PlayBtn2, Earth;
	
	
	public MainMenu() {
		super();
		
		MenuImg = new Image("MainBG.jpg");
		PlayBtn1 = new Image("PlayBtn1.png");
		PlayBtn2 = new Image("PlayBtn2.png");
		
		GraphicsContext gc = MenuBG.getGraphicsContext2D();
		gc.drawImage(MenuImg, 0, 0, SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
		gc.drawImage(Earth, 0, 0, 30, 30);
		getChildren().add(MenuBG);
		
		Canvas MainLabel = new Canvas(400,300);
		GraphicsContext gc2 = MainLabel.getGraphicsContext2D();
		
		gc2.setFont(headFont);
		gc2.setFill(Color.WHITE);
		gc2.setTextBaseline(VPos.CENTER);
		gc2.setTextAlign(TextAlignment.CENTER);
		gc2.fillText("LOST\nSTAR", 200, 150);
		gc2.strokeText("LOST\nSTAR", 200, 150);
		
		
		changeCenter(MainLabel, 0, 0);
		getChildren().add(MainLabel);

		PlayBtn = drawButton(PlayBtn1);	
		addCanvasEvents(PlayBtn, "Play", PlayBtn1, PlayBtn2);
		
		getChildren().add(PlayBtn);
		changeCenter(PlayBtn, 150, 300);

		
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
				if(buttonName=="Quit") Platform.exit();
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
