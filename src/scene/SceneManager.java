package scene;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.GameManager;
import logic.Holder;

public class SceneManager{
	private static Stage primaryStage;
	public static final double SCENE_WIDTH = 375;
	public static final double SCENE_HEIGHT = 600;
	
	private static Pane mainMenu = new MainMenu();
	private static Scene mainMenuScene = new Scene(mainMenu,SCENE_WIDTH,SCENE_HEIGHT);
	
	public static void initialize(Stage stage) {
		primaryStage = stage;
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void gotoMainMenu() {
		primaryStage.setScene(mainMenuScene);
	}
	
	public static void gotoSceneOf(Pane pane) {
		Scene sceneToGo = new Scene(pane,SCENE_WIDTH,SCENE_HEIGHT);
		primaryStage.setScene(sceneToGo);
	}
	
	public static void goToGameScene() {
		GameManager.startGame();
//		Scene scene = new Scene(Holder.getInstance().getGameStage());
		primaryStage.setTitle("GameScene");
		primaryStage.setScene(new Scene(Holder.getInstance().getGameStage()));
		
	}
	
	

	
}
