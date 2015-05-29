package com.filip.libgdx.clicker.gameworld;

import com.badlogic.gdx.Gdx;
import com.filip.libgdx.clicker.gameobjects.GameObjectHandler;

public class GameWorld {
	
	private GameState currentState;
	private int height;
	private int width;
	private GameObjectHandler handler;
	
	public enum GameState {
		READY, RUNNING, GAMEOVER, HISCORE
	}
	
	public GameWorld(int width, int height) {
		this.height = height;
		this.width = width;
		handler = new GameObjectHandler(width, height);
		currentState= GameState.READY;
		
	}
	
	public void start() {
		currentState = GameState.RUNNING;
		Gdx.app.log("world","start");
	}

	public void update(float delta,float gameSpeed,float runTime) {
		// TODO Auto-generated method stub
		switch(currentState) {
		case READY :
			updateReady(delta);
		break;
		case RUNNING :
			updateRunning(delta, gameSpeed, runTime);
		break;
		case GAMEOVER:
			updateGameOver(delta);
		break;
		case HISCORE:
			updateHiscore(delta);
		break;
			
	
		
	}
	}

	private void updateHiscore(float delta) {
		// TODO Auto-generated method stub
		
	}

	private void updateGameOver(float delta) {
		// TODO Auto-generated method stub
		
	}

	private void updateReady(float delta) {
		// TODO Auto-generated method stub
		
	}

	private void updateRunning(float delta, float gameSpeed, float runTime) {
		// TODO Auto-generated method stub
		handler.update(delta, gameSpeed, runTime);		
	}
	
	public GameState getCurrentState() {
		return currentState;
	}

	public void keyUp() {
		// TODO Auto-generated method stub
		Gdx.app.log("Martinka ", "hore");
		handler.getFigure().jump();		
	}

	public void keyDown() {
		// TODO Auto-generated method stub
		Gdx.app.log("Martinka ", "dole");
		handler.getFigure().slide();
	}
	
	public GameObjectHandler getHandler() {
		return handler;
	}
	

}
