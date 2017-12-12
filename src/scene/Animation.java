package scene;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;

public class Animation extends Pane {
	
	public boolean isStop = false;
	
	public Animation() {
		
	}
	
	public void drawVLightning(int y) {
		Canvas VLightning = new Canvas(375, 375/7);
		GraphicsContext gc = VLightning.getGraphicsContext2D();
		ResLoader.electricSound.play();
		new AnimationTimer() {
			int i = 0;
			public void handle(long currentNanoTime) {
				try {
					Thread.sleep(30);
					i++;
					WritableImage croppedimg = new WritableImage(ResLoader.VLightningAniImg.getPixelReader(), 0, 54*(i%8), 375, 54);
					gc.clearRect(0, 0, 375, 375/7);
					gc.drawImage(croppedimg, 0, 0, 375, 375/7);
					if(i==7) {
						isStop = true;
						ResLoader.electricSound.stop();
						gc.clearRect(0, 0, 375, 375/7);
						this.stop();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
		VLightning.setTranslateY(y);
		getChildren().add(VLightning);
	}
	
	public void drawHLightning(int x) {
		Canvas HLightning = new Canvas(375/7, (375/7)*8);
		GraphicsContext gc = HLightning.getGraphicsContext2D();
		ResLoader.electricSound.play();
		new AnimationTimer() {
			int i = 0;
			public void handle(long currentNanoTime) {
				try {
					Thread.sleep(30);
					i++;
					WritableImage croppedimg = new WritableImage(ResLoader.HLightningAniImg.getPixelReader(), 54*(i%8), 0, 54, 375);
					gc.clearRect(0, 0, 375/7, (375/7)*8);
					gc.drawImage(croppedimg, 0, 0, 375/7, (375/7)*8);
					if(i==7) {
						isStop = true;
						ResLoader.electricSound.stop();
						gc.clearRect(0, 0, 375/7, (375/7)*8);
						this.stop();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
		HLightning.setTranslateX(x);
		getChildren().add(HLightning);
	}
	
	public void drawBomb(int x, int y) {
		Canvas Bomb = new Canvas(375/7, 375/7);
		GraphicsContext gc = Bomb.getGraphicsContext2D();
		ResLoader.bangSound.setVolume(0.3);
		ResLoader.bangSound.play();
		new AnimationTimer() {
			int i = 0;
			public void handle(long currentNanoTime) {
				try {
					Thread.sleep(20);
					if(i>15) {
						isStop = true;
						ResLoader.electricSound.stop();
						gc.clearRect(0, 0, 375/7, 375/7);
						this.stop();
					}else {
						WritableImage croppedimg = new WritableImage(ResLoader.ExplosionAniImg.getPixelReader(), 100*(i%16), 0, 100, 100);
						gc.clearRect(0, 0, 375/7, 375/7);
						gc.drawImage(croppedimg, 0, 0, 375/7, 375/7);
						i++;
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
		Bomb.setTranslateX(x);
		Bomb.setTranslateY(y);
		getChildren().add(Bomb);
	}
	
	
}
