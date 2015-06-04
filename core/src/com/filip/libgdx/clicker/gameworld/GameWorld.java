package com.filip.libgdx.clicker.gameworld;

import com.badlogic.gdx.Gdx;
import com.filip.libgdx.clicker.gameobjects.GameObjectHandler;
import com.filip.libgdx.clicker.helpers.AssetLoader;
import com.filip.libgdx.clicker.networklayer.reqHiscores;

public class GameWorld {
	
	private GameState currentState;
	private int height;
	private int width;
	private GameObjectHandler handler;
	private float score;
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
	}

	public void update(float delta,float gameSpeed,float runTime, float runningTime) {
		// TODO Auto-generated method stub
		handler.update(delta, runTime, gameSpeed, runningTime);
		score += gameSpeed/(1/delta);
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
	
	public void coinGained() {
		AssetLoader.addCoin();
	}

	public int getScore() {
		return (int) score;
	}
	
	public void gameOver() { 
		if ((int) score > AssetLoader.getHiscore()) {
			currentState = GameState.HISCORE;
			AssetLoader.setHiscore((int)score);
		} else {
			currentState = GameState.GAMEOVER;
		}
	}

	
	public void pause() {
		currentState = GameState.PAUSE;
	}
	
	public void resume() {
		currentState = GameState.RUNNING;
	}

	public void doubleJumpGained() {
		// TODO Auto-generated method stub
		handler.getFigure().doubleJumpGained();
		
	}
	
	public void restart() {
		currentState= GameState.READY;
		handler.restart();
		score = 0;
	}
	
}
