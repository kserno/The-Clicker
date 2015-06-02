package com.filip.libgdx.clicker.gameobjects;

import com.badlogic.gdx.math.Vector2;

public class Boost extends GameObject{
	
	public Boost(float x,float y, int width, int height) {
		super(x,y,width,height);
		super.velocity.set(-200, 0);
	}

}
