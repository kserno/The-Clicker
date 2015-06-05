package com.filip.libgdx.clicker.gameobjects;

import java.util.Random;

public abstract class Obstacle extends GameObject{

	protected static int defVelocity = -200;
	
	public Obstacle(float x, float y, int width, int height, float gameSpeed) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		super.velocity.set(defVelocity*gameSpeed,0);
	}
	
	public void update(float delta,float gameSpeed) {
		// TODO Auto-generated method stub
		super.update(delta);
		velocity.x = defVelocity* gameSpeed;
	}

	
	

}
