package com.filip.libgdx.clicker.gameobjects;

import com.badlogic.gdx.math.Vector2;

public class Figure extends GameObject  {
	
	private Vector2 acceleration;
	private float rotation;
	private float startingY;
	
	
	public Figure(float x, float y, int width, int height) {
		// TODO Auto-generated constructor stub
		super(x,y,width,height);
		acceleration = new Vector2(0,300);
		rotation = 0f;
		startingY = y;
	}
	
	@Override
	protected void update(float delta) {
		// TODO Auto-generated method stub
		if (position.y!=startingY) {
			velocity.add(acceleration.cpy().scl(delta));
		}
		super.update(delta);
		
	}

	public void jump() {
		// TODO Auto-generated method stub
		velocity.y = -140;		
	}
	
	public void slide() {
		rotation = 90f;		
	}
	
	public float getRotation() {
		return rotation;
	}
	

}
