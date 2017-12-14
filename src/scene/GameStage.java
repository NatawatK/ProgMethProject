package scene;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import logic.GameManager;

public class GameStage extends Pane{
	public final static double GAME_WIDTH = 375 ;
	public final static double GAME_HEIGHT = 600;
	public final static double LOSE_LINE = GAME_HEIGHT - 50;

	protected static Canvas canvas;
	protected Image gameBG;
	
	public GameStage() {
		this.Initialize();
		this.setEvent();
	}
	
	private void Initialize() {
		this.setWidth(GAME_WIDTH);
		this.setHeight(GAME_HEIGHT);
		canvas = new Canvas(GAME_WIDTH, GAME_HEIGHT);
		this.getChildren().add(canvas);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gameBG = ResLoader.GameBG;
		gc.drawImage(gameBG, 0, 0, GAME_WIDTH, GAME_HEIGHT);
	}
	
	private void setEvent() {
		this.setOnMouseMoved(E -> GameManager.aim(E.getSceneX(), E.getSceneY()));
		this.setOnMouseClicked(E -> {
			if(E.getButton() == MouseButton.PRIMARY) {
				GameManager.shoot();
//				System.out.println("Shoot to : " + E.getSceneX() + " " + E.getSceneY());
			}	
			if(E.getButton() == MouseButton.SECONDARY) {
				GameManager.retrieve();
			}
		});
	}
	
	/*******************************
	
	public void drawAboveBar() {
		Canvas canvas = new Canvas(GAME_WIDTH, 50);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, GAME_WIDTH, 50);
		gc.setFill(Color.WHITE);
		gc.setTextBaseline(VPos.CENTER);
		gc.setTextAlign(TextAlignment.CENTER);
		gc.fillText("LEVEL", GAME_WIDTH/2, 10);
		gc.fillText("99", GAME_WIDTH, 30);
		getChildren().add(canvas);
	}
	/*******************************/
}
