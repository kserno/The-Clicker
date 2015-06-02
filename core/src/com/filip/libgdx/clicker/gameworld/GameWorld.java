package com.filip.libgdx.clicker.gameworld;

import com.badlogic.gdx.Gdx;
import com.filip.libgdx.clicker.gameobjects.GameObjectHandler;
import com.filip.libgdx.clicker.helpers.AssetLoader;

public class GameWorld {
	
	private GameState currentState;
	private int height;
	private int width;
	private GameObjectHandler handler;
	private boolean isFreezed;
	
	public enum GameState {
		READY, RUNNING, GAMEOVER,PAUSE ,HISCORE
	}
	
	public GameWorld(int width, int height) {
		this.height = height;
		this.width = width;
		handler = new GameObjectHandler(width, height, this);
		currentState= GameState.READY;		
	}
	
	public void start() {
		currentState = GameState.RUNNING;
		Gdx.app.log("world","start");
	}

	public void update(float delta,float gameSpeed,float runTime, float runningTime) {
		// TODO Auto-generated method stub
		handler.update(delta, runTime, gameSpeed, runningTime);

	}
	
	public GameState getCurrentState() {
		return currentState;
	}

	public void keyUp() {
		// TODO Auto-generated method stub
		handler.getFigure().jump();		
	}

	public void keyDown() {
		// TODO Auto-generated method stub
		handler.getFigure().slide();
	}
	
	public GameObjectHandler getHandler() {
		return handler;
	}

	public void freeze() {
		// TODO Auto-generated method stub
		isFreezed = true;
	}
	
	public void coinGained() {
		AssetLoader.addCoin();
	}

}
