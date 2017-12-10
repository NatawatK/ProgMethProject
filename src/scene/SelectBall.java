package scene;

import java.awt.Label;

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

public class SelectBall extends Pane{
	
	private final double CHAR_WIDTH = 100;
	private final double CHAR_HEIGHT = 100;
	public static final Font headFont = Font.font("Monospace", FontWeight.BOLD,36);
	private Canvas BGCanvas = new Canvas(SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
	private Canvas EarthBoard, EarthBorder, EarthImgCanvas;
	private Canvas MarsBoard, MarsBorder, MarsImgCanvas;
	private Canvas MoonBoard, MoonBorder, MoonImgCanvas;
	private Canvas PlutoBoard, PlutoBorder, PlutoImgCanvas;
	private Canvas SaturnBoard, SaturnBorder, SaturnImgCanvas;
	private Canvas UranusBoard, UranusBorder, UranusImgCanvas;
	private String ballState = "";
	
	public SelectBall() {
		super();
		
		GraphicsContext gc = BGCanvas.getGraphicsContext2D();
		gc.drawImage(ResLoader.SelectBallImg, 0, 0, SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
		getChildren().add(BGCanvas);
		
		Canvas SelectBallLabel = new Canvas(400,200);
		GraphicsContext gc2 = SelectBallLabel.getGraphicsContext2D();
		
		gc2.setFont(headFont);
		gc2.setFill(Color.WHITE);
		gc2.setTextBaseline(VPos.CENTER);
		gc2.setTextAlign(TextAlignment.CENTER);
		gc2.fillText("SELECT BALL", SceneManager.SCENE_WIDTH/2, 100);
		
		changeCenter(SelectBallLabel, 0, 0);
		getChildren().add(SelectBallLabel);
		
		String Earth = "Earth";
		EarthBoard = drawField();
		EarthImgCanvas = drawImg(ResLoader.EarthImg);
		EarthBorder = drawBorder();
		addCanvasEvents(EarthBoard, EarthBorder, Earth);
		
		changeCenter(EarthBoard, (SceneManager.SCENE_WIDTH-3*CHAR_WIDTH)/2, 200);
		changeCenter(EarthBorder, (SceneManager.SCENE_WIDTH-3*CHAR_WIDTH)/2, 200);
		changeCenter(EarthImgCanvas, (SceneManager.SCENE_WIDTH-3*CHAR_WIDTH)/2, 200);
		getChildren().addAll(EarthBoard, EarthImgCanvas, EarthBorder);

		String Mars = "Mars";
		MarsBoard = drawField();
		MarsImgCanvas = drawImg(ResLoader.MarsImg);
		MarsBorder = drawBorder();
		addCanvasEvents(MarsBoard, MarsBorder, Mars);
		
		this.changeCenter(MarsBoard, (SceneManager.SCENE_WIDTH-3*CHAR_WIDTH)/2+CHAR_WIDTH, 200);
		this.changeCenter(MarsBorder, (SceneManager.SCENE_WIDTH-3*CHAR_WIDTH)/2+CHAR_WIDTH, 200);
		this.changeCenter(MarsImgCanvas, (SceneManager.SCENE_WIDTH-3*CHAR_WIDTH)/2+CHAR_WIDTH, 200);
		this.getChildren().addAll(MarsBoard, MarsImgCanvas, MarsBorder);
		
		String Moon = "Moon";
		MoonBoard = drawField();
		MoonImgCanvas = drawImg(ResLoader.MoonImg);
		MoonBorder = drawBorder();
		this.addCanvasEvents(MoonBoard, MoonBorder, Moon);
		
		this.changeCenter(MoonBoard, (SceneManager.SCENE_WIDTH-3*CHAR_WIDTH)/2+2*CHAR_WIDTH, 200);
		this.changeCenter(MoonBorder, (SceneManager.SCENE_WIDTH-3*CHAR_WIDTH)/2+2*CHAR_WIDTH, 200);
		this.changeCenter(MoonImgCanvas, (SceneManager.SCENE_WIDTH-3*CHAR_WIDTH)/2+2*CHAR_WIDTH, 200);
		this.getChildren().addAll(MoonBoard, MoonImgCanvas, MoonBorder);
		
		String Pluto = "Pluto";
		PlutoBoard = drawField();
		PlutoImgCanvas = drawImg(ResLoader.PlutoImg);
		PlutoBorder = drawBorder();
		this.addCanvasEvents(PlutoBoard, PlutoBorder, Pluto);
		
		this.changeCenter(PlutoBoard, (SceneManager.SCENE_WIDTH-3*CHAR_WIDTH)/2, 300);
		this.changeCenter(PlutoBorder, (SceneManager.SCENE_WIDTH-3*CHAR_WIDTH)/2, 300);
		this.changeCenter(PlutoImgCanvas, (SceneManager.SCENE_WIDTH-3*CHAR_WIDTH)/2, 300);
		this.getChildren().addAll(PlutoBoard, PlutoImgCanvas, PlutoBorder);
		
		String Saturn = "Saturn";
		SaturnBoard = drawField();
		SaturnImgCanvas = drawImg(ResLoader.SaturnImg);
		SaturnBorder = drawBorder();
		this.addCanvasEvents(SaturnBoard, SaturnBorder, Saturn);
		
		this.changeCenter(SaturnBoard, (SceneManager.SCENE_WIDTH-3*CHAR_WIDTH)/2+CHAR_WIDTH, 300);
		this.changeCenter(SaturnBorder, (SceneManager.SCENE_WIDTH-3*CHAR_WIDTH)/2+CHAR_WIDTH, 300);
		this.changeCenter(SaturnImgCanvas, (SceneManager.SCENE_WIDTH-3*CHAR_WIDTH)/2+CHAR_WIDTH, 300);
		this.getChildren().addAll(SaturnBoard, SaturnImgCanvas, SaturnBorder);
		
		String Uranus = "Uranus";
		UranusBoard = drawField();
		UranusImgCanvas = drawImg(ResLoader.UranusImg);
		UranusBorder = drawBorder();
		this.addCanvasEvents(UranusBoard, UranusBorder, Uranus);
		
		this.changeCenter(UranusBoard, (SceneManager.SCENE_WIDTH-3*CHAR_WIDTH)/2+2*CHAR_WIDTH, 300);
		this.changeCenter(UranusBorder, (SceneManager.SCENE_WIDTH-3*CHAR_WIDTH)/2+2*CHAR_WIDTH, 300);
		this.changeCenter(UranusImgCanvas, (SceneManager.SCENE_WIDTH-3*CHAR_WIDTH)/2+2*CHAR_WIDTH, 300);
		this.getChildren().addAll(UranusBoard, UranusImgCanvas, UranusBorder);
		
		
	}
	
	private void changeCenter(Canvas canvas,double x, double y) {
		canvas.setTranslateX(x);
		canvas.setTranslateY(y);
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
				if(ballState=="" || ballState!=buttonName) {
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
