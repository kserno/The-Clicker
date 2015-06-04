package com.filip.libgdx.clicker.gameobjects;

public class Coin extends Boost{

	public Coin(Ground ground, int totalWidth, int totalHeight, float gameSpeed, int gap) {
		super(totalWidth, ground.getY()-gap, totalWidth/15, totalWidth/15, gameSpeed);
		// TODO Auto-generated constructor stub
	}

}
