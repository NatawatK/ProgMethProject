package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import logic.Holder;
import scene.GameStage;
import scene.MainMenu;
import scene.ResLoader;
import scene.SceneManager;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;


public class MainToGameScene extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			ResLoader.loadResource();
			GameStage game = Holder.getInstance().getGameStage();
			
			Scene scene = new Scene(game);
			primaryStage.setResizable(false);
			primaryStage.setTitle("GameScene");
			primaryStage.setScene(scene);

			logic.GameManager.startGame();

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
