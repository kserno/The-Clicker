package com.filip.libgdx.clicker.gameobjects;

public abstract class Obstacle extends GameObject{

	public Obstacle(float x, float y, int width, int height, float gameSpeed) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		super.velocity.set(-200*gameSpeed,0);
	}
	
	

}
