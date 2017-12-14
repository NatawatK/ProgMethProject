package scene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import logic.GameManager;
import logic.Holder;

public class Animation extends Pane {
	
	public void drawVLightning(int x) {
		ResLoader.electricSound.play();
		ImageView iv = new ImageView();
		Image i = new Image(ClassLoader.getSystemResource("img/newV.gif").toString());
		iv.setImage(i);
		iv.setFitHeight((double) GameManager.GRID_SIZE*8);
		iv.setFitWidth((double) GameManager.GRID_SIZE-10);
		iv.setTranslateX(x-20);
		iv.setTranslateY(100);
		Holder.getInstance().getGameStage().getChildren().add(iv);
	}
	
	public void drawHLightning(int y) {
		ResLoader.electricSound.play();
		ImageView iv = new ImageView();
		Image i = new Image(ClassLoader.getSystemResource("img/newH.gif").toString());
		iv.setImage(i);
		iv.setFitWidth((double) GameManager.GRID_SIZE*8);
		iv.setFitHeight((double) GameManager.GRID_SIZE-10);
		iv.setTranslateY(y-20);
		Holder.getInstance().getGameStage().getChildren().add(iv);
	}
	
	public void drawBomb(int x, int y) {
		ResLoader.bangSound.play();
		ImageView iv = new ImageView();
		Image i = new Image(ClassLoader.getSystemResource("img/newBomb.gif").toString());
		iv.setImage(i);
		iv.setFitHeight((double) GameManager.GRID_SIZE);
		iv.setFitWidth((double) GameManager.GRID_SIZE);
		iv.setTranslateX(x);
		iv.setTranslateY(y);
		Holder.getInstance().getGameStage().getChildren().add(iv);
	}
	
	
}
