package com.filip.libgdx.clicker.gameobjects;

import com.badlogic.gdx.math.Vector2;

public class Figure extends GameObject  {
	
	private Vector2 acceleration;
	private float rotation;
	private float startingY;
	
	private Boolean isJumping= false;
	
	
	public Figure(float x, float y, int width, int height) {
		// TODO Auto-generated constructor stub
		super(x,y,width,height);
		acceleration = new Vector2(0,980);
		rotation = 0f;
		startingY = y;
	}
	
	@Override
	protected void update(float delta) {
		// TODO Auto-generated method stub
		if (position.y<(int)startingY) {
			velocity.add(acceleration.cpy().scl(delta));		
		}
		if (position.y >= (int)startingY) {
			position.y=startingY;
			isJumping = false;
		}
		super.update(delta);
		
	}

	public void jump() {
		// TODO Auto-generated method stub
		if (!isJumping ) {
			isJumping= true;
			velocity.y = -400;		
		}
	}
	
	public void slide() {
		rotation = -90f;		
	}
	
	public float getRotation() {
		return rotation;
	}
	
	public Boolean getIsJumping() {
		return isJumping;
	}

	public void die() {
		// TODO Auto-generated method stub
		
	}

}
