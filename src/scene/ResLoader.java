package scene;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class ResLoader {
	
	public static Image MenuImg, PlayBtn1, PlayBtn2;
	public static Image SpaceCraftImg;
	public static Image SelectBallImg, EarthImg, MarsImg, MoonImg, PlutoImg, SaturnImg, UranusImg;
	public static Image GameOverImg, ReplayBtn1, ReplayBtn2, HomeBtn1, HomeBtn2;
	public static Image RetriveBallImg, RandomReflectorImg, VLightningImg, HLightningImg, BallPlusImg;
	public static Image HLightningAniImg, VLightningAniImg, ExplosionAniImg;
	public static AudioClip electricSound, bangSound, collectSound, bounceWallSound, bounceBlockSound, reflectorSound;
	
	public static void loadResource() {
		
		MenuImg = new Image(ClassLoader.getSystemResource("img/MainBG.jpg").toString());
		PlayBtn1 = new Image(ClassLoader.getSystemResource("img/PlayBtn1.png").toString());
		PlayBtn2 = new Image(ClassLoader.getSystemResource("img/PlayBtn2.png").toString());
		
		GameOverImg = new Image(ClassLoader.getSystemResource("img/BG3.jpg").toString());
		ReplayBtn1 = new Image(ClassLoader.getSystemResource("img/ReplayBtn1.png").toString());
		ReplayBtn2 = new Image(ClassLoader.getSystemResource("img/ReplayBtn2.png").toString());
		HomeBtn1 = new Image(ClassLoader.getSystemResource("img/HomeBtn1.png").toString());
		HomeBtn2 = new Image(ClassLoader.getSystemResource("img/HomeBtn2.png").toString());
		
		SelectBallImg = new Image(ClassLoader.getSystemResource("img/BG6.jpg").toString());
		EarthImg = new Image(ClassLoader.getSystemResource("img/Earth.png").toString());
		MarsImg = new Image(ClassLoader.getSystemResource("img/Mars.png").toString());
		MoonImg = new Image(ClassLoader.getSystemResource("img/Moon.png").toString());
		PlutoImg = new Image(ClassLoader.getSystemResource("img/Pluto.png").toString());
		SaturnImg = new Image(ClassLoader.getSystemResource("img/Saturn.png").toString());
		UranusImg = new Image(ClassLoader.getSystemResource("img/Uranus.png").toString());
		
		SpaceCraftImg = new Image(ClassLoader.getSystemResource("img/SpaceCraft.png").toString());
		
		RetriveBallImg = new Image(ClassLoader.getSystemResource("img/Retrieve.png").toString());
		RandomReflectorImg = new Image(ClassLoader.getSystemResource("img/BallPlus.png").toString());
		BallPlusImg = new Image(ClassLoader.getSystemResource("img/RandomReflector.png").toString());
		VLightningImg = new Image(ClassLoader.getSystemResource("img/VLightning.png").toString());
		HLightningImg = new Image(ClassLoader.getSystemResource("img/HLightning.png").toString());
		
		VLightningAniImg = new Image(ClassLoader.getSystemResource("img/VLightningAni.png").toString()); // 375x432 pixel 8 frame
		HLightningAniImg = new Image(ClassLoader.getSystemResource("img/HLightningAni.png").toString());
		ExplosionAniImg = new Image(ClassLoader.getSystemResource("img/ExplosionAni.png").toString());
		
		electricSound = new AudioClip(ClassLoader.getSystemResource("sound/ESPARK1.wav").toString());
		bangSound = new AudioClip(ClassLoader.getSystemResource("sound/bang1.wav").toString());
		collectSound = new AudioClip(ClassLoader.getSystemResource("sound/collect.wav").toString());
		bounceWallSound = new AudioClip(ClassLoader.getSystemResource("sound/bing2.wav").toString());
		bounceBlockSound = new AudioClip(ClassLoader.getSystemResource("sound/bing.wav").toString());
//		reflectorSound = new AudioClip(ClassLoader.getSystemResource("pang.wav").toString()); 
		
	}
	
}
