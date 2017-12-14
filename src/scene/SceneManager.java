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
//		ResLoader.bgmSound.play();
	}
	
	public static void gotoMainMenu() {
		ResLoader.bgmSound.stop();
		ResLoader.bgmSound.play();
		primaryStage.setScene(mainMenuScene);
	}
	
	public static void gotoSceneOf(Pane pane) {
		ResLoader.bgmSound.stop();
		ResLoader.bgmSound.play();
		Scene sceneToGo = new Scene(pane,SCENE_WIDTH,SCENE_HEIGHT);
		primaryStage.setScene(sceneToGo);
	}
	
	public static void goToGameScene() {
		ResLoader.bgmSound.stop();
		GameManager.startGame();
//		Scene scene = new Scene(Holder.getInstance().getGameStage());
		primaryStage.setScene(new Scene(Holder.getInstance().getGameStage()));
		
	}
	
	

	
}
