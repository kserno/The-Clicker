package com.filip.libgdx.clicker.gameobjects;

import com.badlogic.gdx.math.Vector2;

public class Boost extends GameObject{
	
	protected static int defVelocity = -200;
	
	public Boost(float x,float y, int width, int height, float gameSpeed) {
		super(x,y,width,height);
		super.velocity.set(defVelocity*gameSpeed, 0);
	}
	
	public void update(float delta, float gameSpeed) {
		super.update(delta);
		velocity.x = defVelocity*gameSpeed;
	}

}
