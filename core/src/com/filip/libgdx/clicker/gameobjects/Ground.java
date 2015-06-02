package com.filip.libgdx.clicker.gameobjects;

import com.badlogic.gdx.graphics.Color;

public class Ground extends GameObject{
	
	protected Color color;
	
	public Ground(float x, float y, int width , int height) {
		// TODO Auto-generated constructor stub
		super(x,y,width,height);
		color = new Color(147/255f, 80/255f, 21/255f,1 );
	}
	
	public Color getColor() {
		return color;
	}

}
