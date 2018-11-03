package scene;

<<<<<<< HEAD
import javafx.application.Platform;
=======

>>>>>>> 159751500d0efa0a1717de865e78087068b3e5bb
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class SelectBall extends Pane{
	
	public SelectBall() {
		super();
		
		String PB = "1 Player";
		Canvas P1Button = drawButton(PB);	
		addCanvasEvents(P1Button,PB);
		
		String QB = "2 Player";
		Canvas P2Button = drawButton(QB);	
		addCanvasEvents(P2Button,QB);
		
//		String Char1 = "Character 1";
//		Canvas Char1Button = drawChar();
//		addCanvasEvents(Char1Button,Char1);
//		
//		String Char2 = "Character 2";
//		Canvas Char2Button = drawChar();
//		addCanvasEvents(Char2Button,Char2);
		
		getChildren().add(P1Button);
		changeCenter(P1Button, 100, 50);
		
		getChildren().add(P2Button);
		changeCenter(P2Button, 250, 50);
		
//		getChildren().add(Char1Button);
//		changeCenter(Char1Button, 250, 150);
//		
//		getChildren().add(Char2Button);
//		changeCenter(Char2Button, 250, 150);
		
	}
	
	public void changeCenter(Canvas canvas,double x, double y) {
		canvas.setTranslateX(x);
		canvas.setTranslateY(y);
	}
	
//	private Canvas drawChar() {
//		
//	}
	
	private Canvas drawButton(String name) {
		Canvas btn = new Canvas(100,50);
		GraphicsContext gc = btn.getGraphicsContext2D();
		
		gc.setFill(Color.DARKGRAY);
		gc.fillRoundRect(0, 0, 150, 70, 10, 10);
	
		gc.setFont(SceneManager.theFont);
		gc.setFill(Color.WHITE);
		gc.setTextBaseline(VPos.CENTER);
		gc.setTextAlign(TextAlignment.CENTER);
		gc.fillText(name, 50, 25);
		
		return btn;
	}
	
	public void drawHoverIndicator(Canvas canvas, String name) {
		//TODO Fill Code
		if(name=="Player 1"|| name=="Player 2") {
			GraphicsContext gc = canvas.getGraphicsContext2D();
			
			gc.setFill(Color.RED);
			gc.fillRoundRect(0, 0, 150, 70, 10, 10);
			
			gc.setFont(SceneManager.theFont);
			gc.setFill(Color.WHITE);
			gc.setTextBaseline(VPos.CENTER);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.fillText(name, 50, 25);
		}
//		if(name=="Character 1")
//		if(name=="Character 2")
			
	}

	public void undrawHoverIndicator(Canvas canvas, String name) {
		//TODO Fill Code
		if(name=="Player 1"|| name=="Player 2") {
			GraphicsContext gc = canvas.getGraphicsContext2D();
			
			gc.setFill(Color.DARKGRAY);
			gc.fillRoundRect(0, 0, 150, 70, 10, 10);
		
			gc.setFont(SceneManager.theFont);
			gc.setFill(Color.WHITE);
			gc.setTextBaseline(VPos.CENTER);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.fillText(name, 50, 25);
		}
//		if(name=="Character 1")
//		if(name=="Character 2")
	}
	
	private void addCanvasEvents(Canvas canvas, String buttonName) {
		//TODO Fill Code
		canvas.setOnMouseClicked(new javafx.event.EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
//				if(buttonName=="1 Player") 
//				if(buttonName=="2 Player") 
//				if(buttonName=="Character 1")
//				if(buttonName=="Character 2")
			}
		});
		
		canvas.setOnMouseEntered(new javafx.event.EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				drawHoverIndicator(canvas,buttonName);
			}	
		});
		
		canvas.setOnMouseExited(new javafx.event.EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				undrawHoverIndicator(canvas,buttonName);
			}
			
		});
	}

}
