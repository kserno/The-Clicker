package com.filip.libgdx.clicker.gameobjects;

public class DoubleJump extends Boost{

	public DoubleJump(Ground ground, int totalWidth, int totalHeight, float gameSpeed, int gap) {
		super(totalWidth, ground.getY()-gap, totalWidth/15, totalWidth/15, gameSpeed);


		
	}

}
