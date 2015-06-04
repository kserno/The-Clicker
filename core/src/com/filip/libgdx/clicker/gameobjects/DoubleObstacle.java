package com.filip.libgdx.clicker.gameobjects;

public class DoubleObstacle extends Obstacle {

	public DoubleObstacle(Ground ground,int totalWidth, int totalHeight, float gameSpeed) {
		super(totalWidth, ground.getY()- totalHeight/4, totalWidth/10, totalHeight/4, gameSpeed);
		// TODO Auto-generated constructor stub
	}
	
	

}
