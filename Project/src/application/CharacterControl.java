package application;


import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;

import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class CharacterControl extends Component{
	
	private int speedX=0;
	private int speedY=0;
	
	private AnimatedTexture texture;
	private AnimationChannel animStopU,animStopD,animStopL,animStopR,animWalkUp,animWalkDown,animWalkLeft
	,animWalkRight;
	
	public CharacterControl() {
		
		//Importing sprite sheet, defining frames for each animated direction
		animStopU=new AnimationChannel("CharacterSprite.png",16,32,32,Duration.seconds(1),9,9);
		animStopD=new AnimationChannel("CharacterSprite.png",16,32,32,Duration.seconds(1),1,1);
		animStopL=new AnimationChannel("CharacterSprite.png",16,32,32,Duration.seconds(1),12,12);
		animStopR=new AnimationChannel("CharacterSprite.png",16,32,32,Duration.seconds(1),5,5);
		
		
		animWalkUp=new AnimationChannel("CharacterSprite.png",16,32,32,Duration.seconds(1),8,11);
		animWalkDown=new AnimationChannel("CharacterSprite.png",16,32,32,Duration.seconds(1),0,3);
		animWalkLeft=new AnimationChannel("CharacterSprite.png",16,32,32,Duration.seconds(1),12,15);
		animWalkRight=new AnimationChannel("CharacterSprite.png",16,32,32,Duration.seconds(1),4,7);
		
		texture=new AnimatedTexture(animStopD);
	}
	

	@Override
	public void onAdded() {
		entity.setView(texture);
	}
	@Override
	public void onUpdate(double t) {
		if(speedX != 0) {
			entity.translateX(speedX*t);
		}
		if(speedY != 0) {
			entity.translateY(speedY*t);
		}
	}
	
	public void moveUp() {
		speedY = -100;
		speedX = 0;
		texture.loopAnimationChannel(animWalkUp);
	}
	
	public void moveDown() {
		speedY = 100;
		speedX = 0;
		texture.loopAnimationChannel(animWalkDown);
		entity.translateY(2);
	}
	
	public void moveLeft() {
		speedX = -100;
		speedY = 0;
		entity.translateX(-2);
		texture.loopAnimationChannel(animWalkLeft);
	
	}
	public void moveRight() {
		speedX = 100;
		speedY = 0;
		entity.translateX(2);
		texture.loopAnimationChannel(animWalkRight);
		
	}
	
	
	
	
	

}
