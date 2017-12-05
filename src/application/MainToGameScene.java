package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import scene.GameStage;
import scene.MainMenu;
import scene.SceneManager;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class MainToGameScene extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GameStage gameStage = new GameStage();
			Scene scene = new Scene(gameStage);
			primaryStage.setTitle("GameScene");
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long time) {
				// TODO Auto-generated method stub
				
			}
		};
		timer.start();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
