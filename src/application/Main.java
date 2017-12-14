package application;
	
import com.sun.media.jfxmedia.MediaPlayer;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import scene.ResLoader;
import scene.SceneManager;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			ResLoader.loadResource();
			SceneManager.initialize(primaryStage);
			SceneManager.gotoMainMenu();
			primaryStage.setTitle("SHOOTING STAR");
			primaryStage.centerOnScreen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
