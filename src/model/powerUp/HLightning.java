package model.powerUp;

import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Color;
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
<<<<<<< HEAD
		Holder.getInstance().getAnimation().drawHLightning(y);
=======
//		ResLoader.electricSound.setVolume(50);
//		ResLoader.electricSound.play();
		/********* new animation **********
		Holder.getInstance().getAnimation().drawHLightning((int)x);
		
		/**********************************/
>>>>>>> 159751500d0efa0a1717de865e78087068b3e5bb
		Rectangle2D lightning = new Rectangle2D(0, y, GameStage.GAME_HEIGHT, 1);
		for( Block e : Holder.getInstance().getBlockContainer()) {
			if(e.getRect().intersects(lightning))
				e.decreaseLife();
		}
	}
}
