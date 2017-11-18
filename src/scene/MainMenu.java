package scene;

import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class MainMenu extends GridPane {
	
	public MainMenu() {
		super();
		
		setHgap(20);
		setPadding(new Insets(100,20,20,20));
		
		String PB = "Play";
		Canvas PlayButton = drawButton(PB);	
		addCanvasEvents(PlayButton,PB);
		
		String QB = "Quit";
		Canvas QuitButton = drawButton(QB);	
		addCanvasEvents(QuitButton,QB);
		
		add(PlayButton, 0, 3);
		add(QuitButton, 1, 3);
		
	}
	
	
	private Canvas drawButton(String name) {
		Canvas btn = new Canvas(100,50);
		GraphicsContext gc = btn.getGraphicsContext2D();
		
		gc.setFill(Color.DARKGRAY);
		gc.fillRoundRect(0, 0, 100, 50, 20, 20);
	
		gc.setFont(SceneManager.theFont);
		gc.setFill(Color.WHITE);
		gc.setTextBaseline(VPos.CENTER);
		gc.setTextAlign(TextAlignment.CENTER);
		gc.fillText(name, 50, 25);
		
		return btn;
		

	}
	
	public void drawHoverIndicator(Canvas canvas, String name) {
		//TODO Fill Code
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		gc.setFill(Color.RED);
		gc.fillRoundRect(0, 0, 100, 50, 20, 20);
		
		gc.setFont(SceneManager.theFont);
		gc.setFill(Color.WHITE);
		gc.setTextBaseline(VPos.CENTER);
		gc.setTextAlign(TextAlignment.CENTER);
		gc.fillText(name, 50, 25);
			
	}

	public void undrawHoverIndicator(Canvas canvas, String name) {
		//TODO Fill Code
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		gc.setFill(Color.DARKGRAY);
		gc.fillRoundRect(0, 0, 100, 50, 20, 20);
	
		gc.setFont(SceneManager.theFont);
		gc.setFill(Color.WHITE);
		gc.setTextBaseline(VPos.CENTER);
		gc.setTextAlign(TextAlignment.CENTER);
		gc.fillText(name, 50, 25);
	}
	
	private void addCanvasEvents(Canvas canvas, String buttonName) {
		//TODO Fill Code
		canvas.setOnMouseClicked(new javafx.event.EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(buttonName=="Play") SceneManager.gotoSelectPlayer();
				if(buttonName=="Quit") Platform.exit();
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
