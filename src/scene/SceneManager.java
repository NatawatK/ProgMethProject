package scene;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SceneManager{
	private static Stage primaryStage;
	public static final int SCENE_WIDTH = 400;
	public static final int SCENE_HEIGHT = 600;
	
	private static Pane mainMenuGrid = new MainMenu();
	private static Scene mainMenuScene = new Scene(mainMenuGrid,SCENE_WIDTH,SCENE_HEIGHT);
	public static final Font theFont = Font.font("Monospace",16);
	
	public static void initialize(Stage stage) {
		primaryStage = stage;
		primaryStage.show();
	}
	
	public static void gotoMainMenu() {
		//TODO Fill Code
		primaryStage.setScene(mainMenuScene);
	}
//	
//	public static void gotoGameStage() {
//		//TODO Fill Code
//
//	}
//	
//	public static void gotoSelectPlayer() {
//		//TODO Fill Code
//
//	}
	
	public static void gotoSceneOf(Pane pane) {
		//TODO Fill Code
		Scene sceneToGo = new Scene(pane,SCENE_WIDTH,SCENE_HEIGHT);
		primaryStage.setScene(sceneToGo);
	}
	
	

	
}
