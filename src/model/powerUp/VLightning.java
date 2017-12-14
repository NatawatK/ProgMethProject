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

public class VLightning extends PowerUp{

	public VLightning(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.color = Color.YELLOW;
		this.img = ResLoader.VLightningImg;
		draw();
	}

	@Override
	public void onCollision(CollidableEntity other) {
		// TODO Auto-generated method stub
		this.hitted = true;
		/***** new anim ******
		Holder.getInstance().getAnimation().drawVLightning((int)x);
		/*********************/
		/*******************************/
		ResLoader.electricSound.play();
		ImageView iv = new ImageView();
		Image i = new Image(ClassLoader.getSystemResource("img/newV.gif").toString());
		iv.setImage(i);
		iv.setFitHeight((double) GameManager.GRID_SIZE*8);
		iv.setFitWidth((double) GameManager.GRID_SIZE-10);
		iv.setTranslateX(x-20);
		iv.setTranslateY(100);
		Holder.getInstance().getGameStage().getChildren().add(iv);
		/*******************************/
		Rectangle2D lightning = new Rectangle2D(x, 0, 1, GameStage.GAME_HEIGHT);
		for( Block e : Holder.getInstance().getBlockContainer()) {
			if(e.getRect().intersects(lightning))
				e.decreaseLife();
		}
	}

}
