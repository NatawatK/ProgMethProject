package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import scene.MainMenu;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			MainMenu mainMenu = new MainMenu();
			Scene scene = new Scene(mainMenu,400,400);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("BoomBoomBoomBoomBoom");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
