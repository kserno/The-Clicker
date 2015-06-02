package com.filip.libgdx.clicker.gameobjects;

import java.util.Random;

import com.badlogic.gdx.Gdx;

public class LowerObstacle extends Obstacle {
	
	protected int spriteN;

	public LowerObstacle(float x, float y,int width, int height, float gameSpeed) {
		super(x, y, width, height, gameSpeed);
		// TODO Auto-generated constructor stub
		Random r = new Random();
		spriteN = r.nextInt(4);
	}
	
	public int getSpriteN() {
		return spriteN;
	}

}
