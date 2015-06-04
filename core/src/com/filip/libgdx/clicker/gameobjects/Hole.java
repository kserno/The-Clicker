package com.filip.libgdx.clicker.gameobjects;

import com.badlogic.gdx.Gdx;

public class Hole extends GameObject {
	
	public Hole(Ground ground, float gameSpeed, int totalWidth) {
		super((float) totalWidth, ground.getY(), totalWidth/10, ground.getHeight());
		velocity.set(-200*gameSpeed, 0);
	}
	
	protected void update(float delta,float gameSpeed) {
		// TODO Auto-generated method stub
		super.update(delta);
		velocity.x=-200*gameSpeed;
	}
		
	
	
}
