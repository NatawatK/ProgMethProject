package model.powerUp;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import logic.GameManager;
import logic.Holder;
import model.Block;
import model.CollidableEntity;
import scene.GameStage;
import scene.ResLoader;

public class HLightning extends PowerUp{
	
	public HLightning(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.color = Color.PURPLE;
		this.img = ResLoader.HLightningImg;
		draw();
	}

	@Override
	public void onCollision(CollidableEntity other) {
		// TODO Auto-generated method stub
		this.hitted = true;
//		ResLoader.electricSound.setVolume(50);
//		ResLoader.electricSound.play();
		/********* new animation **********
		Holder.getInstance().getAnimation().drawHLightning((int)y);
		
		/**********************************/
		
		/**********************************************/
		ResLoader.electricSound.play();
		ImageView iv = new ImageView();
		Image i = new Image(ClassLoader.getSystemResource("img/newH.gif").toString());
		iv.setImage(i);
		iv.setFitWidth((double) GameManager.GRID_SIZE*8);
		iv.setFitHeight((double) GameManager.GRID_SIZE-10);
		iv.setTranslateY(y-20);
		Holder.getInstance().getGameStage().getChildren().add(iv);
		/**********************************************/
		Rectangle2D lightning = new Rectangle2D(0, y, GameStage.GAME_HEIGHT, 1);
		for( Block e : Holder.getInstance().getBlockContainer()) {
			if(e.getRect().intersects(lightning))
				e.decreaseLife();
		}
	}
}
