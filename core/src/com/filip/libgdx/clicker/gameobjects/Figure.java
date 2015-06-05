package com.filip.libgdx.clicker.gameobjects;

import sun.security.acl.WorldGroupImpl;

import com.badlogic.gdx.math.Vector2;
import com.filip.libgdx.clicker.helpers.AssetLoader;

public class Figure extends GameObject  {
	
	private Vector2 acceleration;
	private float startingY;
	
	private Boolean isJumping= false;
	private Boolean isSliding=false;
	private boolean isAlive=true;
	private float slideTime;
	
	private Boolean oneMoreJump;
	private Boolean oneMoreHealth;
		
	
	public Figure(float x, float y, int width, int height) {
		// TODO Auto-generated constructor stub
		super(x,y,width,height);
		acceleration = new Vector2(0,980);
		startingY = y;
		oneMoreJump = true;
	}
	
	public void update(float delta, Ground ground) {
		// TODO Auto-generated method stub
		
		if (isJumping) velocity.add(acceleration.cpy().scl(delta));
		if (position.y + height > ground.getY()) {
			velocity.y= 0;
			position.y=startingY;
			isJumping= false;
		}
		
		super.update(delta);
		if (isSliding) slideTime+=delta;
		if (isSliding && slideTime>0.75f) {
			isSliding=false;
			slideTime=0;
			position.y = position.y - height;
			height*=2;
		}
	}


	public void jump() {
		// TODO Auto-generated method stub
		if (isJumping && oneMoreJump) {
			velocity.y = -550;
			oneMoreJump = false;
		}
		if (!isJumping && !isSliding ) {
			isJumping= true;
			velocity.y = -550;		
		}
	}
	
	public void slide() {	
		if (!isJumping && !isSliding) {
			isSliding = true;
			height = height/2;
			position.y = position.y + height;
		}
	}
	
	
	public Boolean getIsJumping() {
		return isJumping;
	}

	public void die() {
		// TODO Auto-generated method stub
		isAlive= false;	
	}

	public Boolean getIsAlive() {
		return isAlive;
	}
	
	public Boolean getIsSliding() {
		return isSliding;
	}
	
	public void doubleJumpGained() {
		oneMoreJump = true;
	}
	
	public Boolean getOneMoreJump() {
		return oneMoreJump;
	}

	public void restart() {
		// TODO Auto-generated method stub
		position.y = startingY;
		isAlive=true;
		
	}

}
