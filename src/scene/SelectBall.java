package scene;

import javafx.application.Platform;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class SelectBall extends Pane{
	
	private final double CHAR_WIDTH = 100;
	private final double CHAR_HEIGHT = 100;
	private Image EarthImg, MarsImg, MoonImg, PlutoImg, SaturnImg, UranusImg;
	private Canvas EarthBoard, EarthBorder, EarthImgCanvas;
	
	
	public SelectBall() {
		super();
		
		loadImg();
		
		String Earth = "Earth";
		EarthBoard = drawField();
		EarthImgCanvas = drawImg(EarthImg);
		EarthBorder = drawBorder();
		this.addCanvasEvents(EarthBoard, EarthBorder, Earth);
		
		this.changeCenter(EarthBoard, 50, 200);
		this.changeCenter(EarthBorder, 50, 200);
		this.changeCenter(EarthImgCanvas, 50, 200);
		this.getChildren().addAll(EarthBoard, EarthImgCanvas, EarthBorder);
		
	}
	
	private void loadImg() {
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
//				if(buttonName=="1 Player") 
//				if(buttonName=="2 Player") 
//				if(buttonName=="Character 1")
//				if(buttonName=="Character 2")
			}
		});
		
		border.setOnMouseEntered(new javafx.event.EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println(1);
				drawHoverIndicator(board);
			}	
		});
		
		border.setOnMouseExited(new javafx.event.EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				undrawHoverIndicator(board);
			}
			
		});
	}

}
