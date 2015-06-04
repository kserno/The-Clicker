package com.filip.libgdx.clicker.gameobjects;

import com.badlogic.gdx.Gdx;

public class UpperObstacle extends Obstacle{

	public UpperObstacle(Ground ground ,int gap, float gameSpeed) {
		super(Gdx.graphics.getWidth(), 0, Gdx.graphics.getWidth()/10,(int) ground.getY()-gap , gameSpeed);
		// TODO Auto-generated constructor stub
	}

}
