package com.filip.libgdx.clicker.gameworld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameRenderer {
	
	private GameWorld myWorld;
	private OrthographicCamera cam;
	
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batcher;

	public GameRenderer(GameWorld world) {
		// TODO Auto-generated constructor stub
		myWorld = world;
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true, 136, 204);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		
		loadAssets();
	}

	private void loadAssets() {
		// TODO Auto-generated method stub
		// here i load sprites and stuff
		
	}
	
	public void update(float delta, float gameSpeed, float runTime) {
		//rendering 
		switch(myWorld.getCurrentState()) {
		case READY :
			updateReady(delta);
		break;
		case RUNNING :
			updateRunning(delta);
		break;
		case GAMEOVER :
			updateGameOver(delta);
		break;
		case HISCORE :
			updateHiscore(delta);
		break;
		}
	}

	private void updateHiscore(float delta) {
		// TODO Auto-generated method stub
		
	}

	private void updateReady(float delta) {
		// TODO Auto-generated method stub
		
	}

	private void updateRunning(float delta) {
		// TODO Auto-generated method stub
		
	}

	private void updateGameOver(float delta) {
		// TODO Auto-generated method stub
		
	}

}
