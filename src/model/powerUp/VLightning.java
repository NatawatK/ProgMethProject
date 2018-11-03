package model.powerUp;

import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Color;
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
<<<<<<< HEAD
		Holder.getInstance().getAnimation().drawVLightning(x);
=======
//		ResLoader.electricSound.play();
		/***** new anim ******
		Holder.getInstance().getAnimation().drawVLightning((int)y);
		/*********************/
>>>>>>> 159751500d0efa0a1717de865e78087068b3e5bb
		Rectangle2D lightning = new Rectangle2D(x, 0, 1, GameStage.GAME_HEIGHT);
		for( Block e : Holder.getInstance().getBlockContainer()) {
			if(e.getRect().intersects(lightning))
				e.decreaseLife();
		}
	}

}
