package com.filip.libgdx.clicker.gameobjects;

import java.util.Random;

import com.badlogic.gdx.Gdx;

public class LowerObstacle extends Obstacle {

	public LowerObstacle(Ground ground, float gameSpeed, int totalHeight) {
		super(Gdx.graphics.getWidth(), ground.getY()- totalHeight/6, Gdx.graphics.getWidth()/10, totalHeight/6, gameSpeed);
	}
	

}
