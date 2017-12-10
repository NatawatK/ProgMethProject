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
	public static final Font headFont = Font.loadFont("file:res/fonts/SPACEBAR.ttf",50);
	private Canvas PlayBtn;
	private Canvas QuitBtn;
	private Canvas MenuBG = new Canvas(SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
	
	private static int width = SceneManager.SCENE_WIDTH;
	private static int height = SceneManager.SCENE_HEIGHT;
	private Canvas exitMenu, yesBtn, noBtn;
	
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

		PlayBtn = drawButton(ResLoader.PlayBtn1);	
		addCanvasEvents(PlayBtn, "Play", ResLoader.PlayBtn1, ResLoader.PlayBtn2);
		
		getChildren().add(PlayBtn);
		changeCenter(PlayBtn, (SceneManager.SCENE_WIDTH-BTN_WIDTH)/2, SceneManager.SCENE_HEIGHT/2);
		
		exitMenu = drawButton("Exit", width / 3 + 40, height / 6, width / 3 - 20, height / 3);
//		addCanvasEvents(exitMenu, "Exit");
		exitMenu.setVisible(false);

		yesBtn = drawButton("Yes", width / 12, height / 18, width / 3 + 60, height / 3 + 50);
//		addCanvasEvents(yesBtn, "Yes");
		yesBtn.setVisible(false);

		noBtn = drawButton("No", width / 12, height / 18, width / 3 + width / 3 - width / 12 - 60, height / 3 + 50);
//		addCanvasEvents(noBtn, "No");
		noBtn.setVisible(false);
		
		getChildren().addAll(exitMenu, yesBtn, noBtn);


		
	}
	

	public static Canvas drawButton(String name, double width, double height, double posX, double posY) {
		Canvas canvas = new Canvas(width, height);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		canvas.setTranslateX(posX);
		canvas.setTranslateY(posY);

			gc.setFill(Color.DARKSALMON);
			gc.fillRoundRect(0, 0, width, height, 30, 30);
			gc.setFill(Color.WHITE);
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
		
		canvas.setOnKeyPressed((KeyEvent e) -> {
			System.out.println(e.getCode().getName());
			if (e.getCode() == KeyCode.ESCAPE) {
				System.out.println("555");
				this.exitMenu.setVisible(true);
				this.yesBtn.setVisible(true);
				this.noBtn.setVisible(true);
			}
		});
		
	}
	
//	private void addCanvasEvents(Canvas canvas, String name) {
//		canvas.setOnKeyPressed((KeyEvent e) -> {
//			System.out.println(e.getCode().getName());
//			if (e.getCode() == KeyCode.ESCAPE) {
//				System.out.println("555");
//				this.exitMenu.setVisible(true);
//				this.yesBtn.setVisible(true);
//				this.noBtn.setVisible(true);
//			}
//		});
//	}
	
	
}
