package scene;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class TestLightning extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		
		ResLoader.loadResource();
		
		StackPane root = new StackPane();
		Scene scene = new Scene(root,400,400);
		stage.setScene(scene);
		stage.setTitle("Lightning");

		Canvas canvas = new Canvas(375, 54);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		
		Canvas canvas2 = new Canvas(54, 375);
		GraphicsContext gc2 = canvas2.getGraphicsContext2D();
		root.getChildren().add(canvas2);
		
		Canvas canvas3 = new Canvas(100, 100);
		GraphicsContext gc3 = canvas3.getGraphicsContext2D();
		root.getChildren().add(canvas3);
		

//		drawVLightningAnimation(gc);
//		drawHLightningAnimation(gc2);
//		drawExplosionAnimation(gc3);
		

		stage.show();
	}

	public void drawVLightningAnimation(GraphicsContext gc) {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ResLoader.electricSound.setCycleCount(100);
				ResLoader.electricSound.play();
			}
		});
		t.start();
		new AnimationTimer() {
			int i = 0;
			public void handle(long currentNanoTime) {
				try {
					Thread.sleep(30);
					i++;
					WritableImage croppedimg = new WritableImage(ResLoader.VLightningAniImg.getPixelReader(), 0, 54*(i%8), 375, 54);
					gc.clearRect(0, 0, 400, 400);
					gc.drawImage(croppedimg, 0, 0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					t.interrupt();
					e.printStackTrace();
				}
			}
		}.start();
			
	}
	
	public void drawHLightningAnimation(GraphicsContext gc) {
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ResLoader.electricSound.setCycleCount(100);
				ResLoader.electricSound.play();
			}
		});
		t.start();
		new AnimationTimer() {
			int i = 0;
			public void handle(long currentNanoTime) {
				try {
					Thread.sleep(30);
					i++;
					WritableImage croppedimg = new WritableImage(ResLoader.HLightningAniImg.getPixelReader(), 54*(i%8), 0, 54, 375);
					gc.clearRect(0, 0, 400, 400);
					gc.drawImage(croppedimg, 0, 0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					t.interrupt();
					e.printStackTrace();
				}
			}
		}.start();
			
	}
	
	public void drawExplosionAnimation(GraphicsContext gc) {
		ResLoader.bangSound.setVolume(0.3);
		ResLoader.bangSound.play();
		new AnimationTimer() {
			int i = 0;
			public void handle(long currentNanoTime) {
				try {
					Thread.sleep(20);
					if(i>15) {
						this.stop();
					}else {
						WritableImage croppedimg = new WritableImage(ResLoader.ExplosionAniImg.getPixelReader(), 100*(i%16), 0, 100, 100);
						gc.clearRect(0, 0, 400, 400);
						gc.drawImage(croppedimg, 0, 0);
						i++;
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
			
	}

}
