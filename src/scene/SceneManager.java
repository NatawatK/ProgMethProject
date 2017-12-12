package scene;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.Holder;

public class SceneManager{
	private static Stage primaryStage;
	public static final int SCENE_WIDTH = 375;
	public static final int SCENE_HEIGHT = 600;
	
	private static Pane mainMenuGrid = new MainMenu();
	private static Scene mainMenuScene = new Scene(mainMenuGrid,SCENE_WIDTH,SCENE_HEIGHT);
	public static final Font theFont = Font.font("Monospace",16);
	
	public static void initialize(Stage stage) {
		primaryStage = stage;
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void gotoMainMenu() {
		//TODO Fill Code
		primaryStage.setScene(mainMenuScene);
	}
	
	public static void gotoSceneOf(Pane pane) {
		//TODO Fill Code
		Scene sceneToGo = new Scene(pane,SCENE_WIDTH,SCENE_HEIGHT);
		primaryStage.setScene(sceneToGo);
	}
	
	public static void goToGameScene() {
		ResLoader.loadResource();
		GameStage game = Holder.getInstance().getGameStage();
		Scene scene = new Scene(game);
		primaryStage.setTitle("GameScene");
		primaryStage.setScene(scene);
		logic.GameManager.startGame();
	}
	
	

	
}
