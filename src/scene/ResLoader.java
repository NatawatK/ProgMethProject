package scene;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class ResLoader {
	
	public static Image MenuImg, PlayBtn1, PlayBtn2;
	public static Image SpaceCraftImg;
	public static Image SelectBallImg, EarthImg, MarsImg, MoonImg, PlutoImg, SaturnImg, UranusImg;
	public static Image GameOverImg ,ReplayBtn1, ReplayBtn2, HomeBtn1, HomeBtn2;
	public static Image RetriveBallImg ,RandomReflectorImg ,VLightningImg ,HLightningImg ,VLightningAniImg ;
	
	
	public static void loadResource() {
		
		MenuImg = new Image(ClassLoader.getSystemResource("MainBG.jpg").toString());
		PlayBtn1 = new Image(ClassLoader.getSystemResource("PlayBtn1.png").toString());
		PlayBtn2 = new Image(ClassLoader.getSystemResource("PlayBtn2.png").toString());
		
		GameOverImg = new Image(ClassLoader.getSystemResource("BG3.jpg").toString());
		ReplayBtn1 = new Image(ClassLoader.getSystemResource("ReplayBtn1.png").toString());
		ReplayBtn2 = new Image(ClassLoader.getSystemResource("ReplayBtn2.png").toString());
		HomeBtn1 = new Image(ClassLoader.getSystemResource("HomeBtn1.png").toString());
		HomeBtn2 = new Image(ClassLoader.getSystemResource("HomeBtn2.png").toString());
		
		SelectBallImg = new Image(ClassLoader.getSystemResource("BG6.jpg").toString());
		EarthImg = new Image(ClassLoader.getSystemResource("Earth.png").toString());
		MarsImg = new Image(ClassLoader.getSystemResource("Mars.png").toString());
		MoonImg = new Image(ClassLoader.getSystemResource("Moon.png").toString());
		PlutoImg = new Image(ClassLoader.getSystemResource("Pluto.png").toString());
		SaturnImg = new Image(ClassLoader.getSystemResource("Saturn.png").toString());
		UranusImg = new Image(ClassLoader.getSystemResource("Uranus.png").toString());
		
		SpaceCraftImg = new Image(ClassLoader.getSystemResource("SpaceCraft.png").toString());
		
		RetriveBallImg = new Image(ClassLoader.getSystemResource("RetrieveBall.png").toString());
		RandomReflectorImg = new Image(ClassLoader.getSystemResource("RandomReflector.png").toString());
		VLightningImg = new Image(ClassLoader.getSystemResource("VLightning.png").toString());
		HLightningImg = new Image(ClassLoader.getSystemResource("HLightning.png").toString());
		VLightningAniImg = new Image(ClassLoader.getSystemResource("VLightningAni.png").toString()); // 375x432 pixel 8 frame
		
//		mapSprite = new Image(ClassLoader.getSystemResource("Map.png").toString());
//		mineSprite = new Image(ClassLoader.getSystemResource("Mine.png").toString());
//		explosionSound = new AudioClip(ClassLoader.getSystemResource("Explosion.wav").toString());
	}
	
}
