package scene;

import java.awt.Label;

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

public class SelectBall extends Pane{
	
	private final double CHAR_WIDTH = 100;
	private final double CHAR_HEIGHT = 100;
	public static final Font headFont = Font.font("Monospace", FontWeight.BOLD,36);
	private Canvas SelectBallBG = new Canvas(SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
	private Image BGImg;
	private Canvas BGCanvas = new Canvas(SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
	private Image EarthImg, MarsImg, MoonImg, PlutoImg, SaturnImg, UranusImg;
	private Canvas EarthBoard, EarthBorder, EarthImgCanvas;
	private Canvas MarsBoard, MarsBorder, MarsImgCanvas;
	private Canvas MoonBoard, MoonBorder, MoonImgCanvas;
	private Canvas PlutoBoard, PlutoBorder, PlutoImgCanvas;
	private Canvas SaturnBoard, SaturnBorder, SaturnImgCanvas;
	private Canvas UranusBoard, UranusBorder, UranusImgCanvas;
	private Canvas StartBtn, StartBorder, StartLabel;
	private String ballState = "";
	
	public SelectBall() {
		super();
		
		loadImg();
		
		GraphicsContext gc = BGCanvas.getGraphicsContext2D();
		gc.drawImage(BGImg, 0, 0, SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
		getChildren().add(BGCanvas);
		
		Canvas SelectBallLabel = new Canvas(400,200);
		GraphicsContext gc2 = SelectBallLabel.getGraphicsContext2D();
		
		gc2.setFont(headFont);
		gc2.setFill(Color.WHITE);
		gc2.setTextBaseline(VPos.CENTER);
		gc2.setTextAlign(TextAlignment.CENTER);
		gc2.fillText("SELECT BALL", 200, 100);
		
		changeCenter(SelectBallLabel, 0, 0);
		getChildren().add(SelectBallLabel);
		
		String Earth = "Earth";
		EarthBoard = drawField();
		EarthImgCanvas = drawImg(EarthImg);
		EarthBorder = drawBorder();
		addCanvasEvents(EarthBoard, EarthBorder, Earth);
		
		changeCenter(EarthBoard, 50, 200);
		changeCenter(EarthBorder, 50, 200);
		changeCenter(EarthImgCanvas, 50, 200);
		getChildren().addAll(EarthBoard, EarthImgCanvas, EarthBorder);

		String Mars = "Mars";
		MarsBoard = drawField();
		MarsImgCanvas = drawImg(MarsImg);
		MarsBorder = drawBorder();
		addCanvasEvents(MarsBoard, MarsBorder, Mars);
		
		this.changeCenter(MarsBoard, 150, 200);
		this.changeCenter(MarsBorder, 150, 200);
		this.changeCenter(MarsImgCanvas, 150, 200);
		this.getChildren().addAll(MarsBoard, MarsImgCanvas, MarsBorder);
		
		String Moon = "Moon";
		MoonBoard = drawField();
		MoonImgCanvas = drawImg(MoonImg);
		MoonBorder = drawBorder();
		this.addCanvasEvents(MoonBoard, MoonBorder, Moon);
		
		this.changeCenter(MoonBoard, 250, 200);
		this.changeCenter(MoonBorder, 250, 200);
		this.changeCenter(MoonImgCanvas, 250, 200);
		this.getChildren().addAll(MoonBoard, MoonImgCanvas, MoonBorder);
		
		String Pluto = "Pluto";
		PlutoBoard = drawField();
		PlutoImgCanvas = drawImg(PlutoImg);
		PlutoBorder = drawBorder();
		this.addCanvasEvents(PlutoBoard, PlutoBorder, Pluto);
		
		this.changeCenter(PlutoBoard, 50, 300);
		this.changeCenter(PlutoBorder, 50, 300);
		this.changeCenter(PlutoImgCanvas, 50, 300);
		this.getChildren().addAll(PlutoBoard, PlutoImgCanvas, PlutoBorder);
		
		String Saturn = "Saturn";
		SaturnBoard = drawField();
		SaturnImgCanvas = drawImg(SaturnImg);
		SaturnBorder = drawBorder();
		this.addCanvasEvents(SaturnBoard, SaturnBorder, Saturn);
		
		this.changeCenter(SaturnBoard, 150, 300);
		this.changeCenter(SaturnBorder, 150, 300);
		this.changeCenter(SaturnImgCanvas, 150, 300);
		this.getChildren().addAll(SaturnBoard, SaturnImgCanvas, SaturnBorder);
		
		String Uranus = "Uranus";
		UranusBoard = drawField();
		UranusImgCanvas = drawImg(UranusImg);
		UranusBorder = drawBorder();
		this.addCanvasEvents(UranusBoard, UranusBorder, Uranus);
		
		this.changeCenter(UranusBoard, 250, 300);
		this.changeCenter(UranusBorder, 250, 300);
		this.changeCenter(UranusImgCanvas, 250, 300);
		this.getChildren().addAll(UranusBoard, UranusImgCanvas, UranusBorder);
		
		String Start = "Start";
		StartBtn = new Canvas(200,70);
		StartBorder = new Canvas(200,70);
		StartLabel = new Canvas(200,70);
		drawButton(StartBtn, StartLabel, StartBorder, Start);
		this.addCanvasEvents(StartBtn, StartBorder, Start);
		
		this.changeCenter(StartBtn, 100, 450);
		this.changeCenter(StartBorder, 100, 450);
		this.changeCenter(StartLabel, 100, 450);
//		this.getChildren().addAll(StartBtn, StartLabel, StartBorder);
		
		
	}
	
	private void loadImg() {
		BGImg = new Image("BG6.jpg");
		EarthImg = new Image("Earth.png");
		MarsImg = new Image("Mars.png");
		MoonImg = new Image("Moon.png");
		PlutoImg = new Image("Pluto.png");
		SaturnImg = new Image("Saturn.png");
		UranusImg = new Image("Uranus.png");
	}
	
	private void changeCenter(Canvas canvas,double x, double y) {
		canvas.setTranslateX(x);
		canvas.setTranslateY(y);
	}
	
	private void drawButton(Canvas btn, Canvas label, Canvas border, String name) {
		GraphicsContext gc = btn.getGraphicsContext2D();
		
		gc.setFill(Color.DARKSALMON);
		gc.fillRoundRect(1, 1, 200-2, 70-2, 20, 20);
	
		GraphicsContext gc2 = label.getGraphicsContext2D();
		
		//gc.setFont(SceneManager.theFont); **will get font later**
		gc2.setFont(headFont);
		gc2.setFill(Color.WHITE);
		gc2.setTextBaseline(VPos.CENTER);
		gc2.setTextAlign(TextAlignment.CENTER);
		gc2.fillText(name, 100, 37.5);
		
		GraphicsContext gc3 = border.getGraphicsContext2D();
		gc3.setFill(Color.WHITE);
		gc3.setLineWidth(2);
		gc3.strokeRoundRect(1, 1, 200-2, 70-2, 20, 20);
		

	}
	
	private Canvas drawBorder() {
		Canvas canvas = new Canvas(CHAR_WIDTH, CHAR_HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.setLineWidth(2);
		gc.strokeRoundRect(1, 1, CHAR_WIDTH-2, CHAR_HEIGHT-2, 20, 20);
		
		return canvas;
	}
	
	private Canvas drawField() {
		Canvas canvas = new Canvas(CHAR_WIDTH, CHAR_HEIGHT);
		canvas.setOpacity(0.5);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.CORNSILK);
		gc.fillRoundRect(1, 1, CHAR_WIDTH-2, CHAR_HEIGHT-2, 20, 20);
		
		return canvas;
		
	}
	
	private Canvas drawImg(Image img) {
		Canvas canvas = new Canvas(CHAR_WIDTH, CHAR_HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.drawImage(img, 10, 10, CHAR_WIDTH-20, CHAR_HEIGHT-20);
		
		return canvas;
	}
	
	public void drawHoverIndicator(Canvas canvas) {
	//TODO Fill Code
		canvas.setOpacity(1);
	}

	public void undrawHoverIndicator(Canvas canvas) {
	//TODO Fill Code
		canvas.setOpacity(0.5);
	}
	
	
	
	private void addCanvasEvents(Canvas board, Canvas border, String buttonName) {
		//TODO Fill Code
		 
		border.setOnMouseClicked(new javafx.event.EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(buttonName == "Start") {
					Pane gameOver = new GameOver();
					Pane gameStage = new GameStage();
					SceneManager.gotoSceneOf(gameOver);
//					SceneManager.gotoSceneOf(gameStage);
				}
				else if(ballState=="" || ballState!=buttonName) {
					undrawHoverIndicator(EarthBoard);
					undrawHoverIndicator(MarsBoard);
					undrawHoverIndicator(MoonBoard);
					undrawHoverIndicator(PlutoBoard);
					undrawHoverIndicator(SaturnBoard);
					undrawHoverIndicator(UranusBoard);
					drawHoverIndicator(board);
					ballState = buttonName;
				}
				else if(ballState == buttonName){
					undrawHoverIndicator(EarthBoard);
					undrawHoverIndicator(MarsBoard);
					undrawHoverIndicator(MoonBoard);
					undrawHoverIndicator(PlutoBoard);
					undrawHoverIndicator(SaturnBoard);
					undrawHoverIndicator(UranusBoard);
					drawHoverIndicator(board);
					ballState = buttonName;
					Pane gameOver = new GameOver();
					SceneManager.gotoSceneOf(gameOver);
				}
				
			}
		});
		
		border.setOnMouseEntered(new javafx.event.EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(buttonName!=ballState) drawHoverIndicator(board);
			}	
		});
		
		border.setOnMouseExited(new javafx.event.EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(buttonName!=ballState) undrawHoverIndicator(board);
			}
			
		});
	}

}
