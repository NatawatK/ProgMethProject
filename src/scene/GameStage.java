package scene;

<<<<<<< HEAD
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
=======
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
>>>>>>> 159751500d0efa0a1717de865e78087068b3e5bb
import logic.GameManager;

public class GameStage extends Pane{
	public final static double GAME_WIDTH = 375 ;
	public final static double GAME_HEIGHT = 550;
	public final static double LOSE_LINE = GAME_HEIGHT - 50;

	protected static Canvas canvas;
<<<<<<< HEAD
=======
	protected Image gameBG;
>>>>>>> 159751500d0efa0a1717de865e78087068b3e5bb
	
	private Canvas topBar1, topBar2;
	public GraphicsContext gc, gc2;

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
<<<<<<< HEAD
		gc.drawImage(ResLoader.GameBG, 0, 0, GAME_WIDTH, GAME_HEIGHT);
		
		topBar1 = new Canvas(GAME_WIDTH, 50);
		gc = topBar1.getGraphicsContext2D();
		topBar1.setOpacity(0.5);
		
		topBar2 = new Canvas(GAME_WIDTH, 50);
		gc2 = topBar2.getGraphicsContext2D();
		
		getChildren().addAll(topBar1,topBar2);
		
		drawTopBar(gc, gc2);
=======
		gameBG = ResLoader.GameBG;
		gc.drawImage(gameBG, 0, 0, GAME_WIDTH, GAME_HEIGHT);
>>>>>>> 159751500d0efa0a1717de865e78087068b3e5bb
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
<<<<<<< HEAD

	}
	
	public void drawTopBar(GraphicsContext gc, GraphicsContext gc2) {

		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, GAME_WIDTH, 50);
		gc2.setFill(Color.WHITE);
		gc2.setTextBaseline(VPos.CENTER);
		gc2.setTextAlign(TextAlignment.CENTER);
		gc2.setFont(Font.font("Monospace", FontWeight.BOLD,20));
		gc2.fillText("LEVEL", GAME_WIDTH/2, 15);
		gc2.fillText("1", GAME_WIDTH/2, 35);
	}
	
	public void redrawLevel(int lvl) {
		gc2.clearRect(0, 0, GAME_WIDTH, 50);
		gc2.setFill(Color.WHITE);
		gc2.setTextBaseline(VPos.CENTER);
		gc2.setTextAlign(TextAlignment.CENTER);
		gc2.setFont(Font.font("Monospace", FontWeight.BOLD,20));
		gc2.fillText("LEVEL", GAME_WIDTH/2, 15);
		gc2.fillText(Integer.toString(lvl), GAME_WIDTH/2, 35);
	}

=======
	}
>>>>>>> 159751500d0efa0a1717de865e78087068b3e5bb
}
