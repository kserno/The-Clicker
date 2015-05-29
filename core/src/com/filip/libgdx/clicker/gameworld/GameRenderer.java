package com.filip.libgdx.clicker.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.filip.libgdx.clicker.gameobjects.Figure;
import com.filip.libgdx.clicker.gameobjects.Obstacle;
import com.filip.libgdx.clicker.helpers.AssetLoader;

public class GameRenderer {
	
	private GameWorld myWorld;
	private OrthographicCamera cam;
	
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batcher;
	
	// Game Objects
	private Figure figure;
	private Obstacle[] obs;
	
	private Animation figureAnimation;
	
	private int height, width;

	public GameRenderer(GameWorld world) {
		// TODO Auto-generated constructor stub
		myWorld = world;
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true, 136, 204);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		
		initGameObjects();
		loadAssets();
	}

	private void initGameObjects() {
		// TODO Auto-generated method stub
		figure = myWorld.getHandler().getFigure();
		obs = myWorld.getHandler().getObs();
	}

	private void loadAssets() {
		// TODO Auto-generated method stub
		// here i load sprites and stuff
		figureAnimation = AssetLoader.figureAnimation;		
	}
	
	public void update(float delta, float gameSpeed, float runTime) {
		//rendering 
		Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	    shapeRenderer.begin(ShapeType.Line);
		
		shapeRenderer.setColor(Color.CYAN);
		shapeRenderer.line(0,height/2,width,height/2);
		
		shapeRenderer.end();
		batcher.begin();
		if (!figure.getIsJumping()) {
			batcher.draw(figureAnimation.getKeyFrame(runTime),figure.getX(),figure.getY() , figure.getWidth(), figure.getHeight() );
		} else {
			batcher.draw(AssetLoader.tr[1], figure.getX(),figure.getY(), figure.getWidth(), figure.getHeight());
		}
		//for (int i = 0; i<5;i++) {
			//batcher.draw(AssetLoader.tr[i+5], i*10, 0, (i+1)*10,30);
		//}
		
		batcher.end();
		
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
		/*shapeRenderer.begin(ShapeType.Filled);
		
		shapeRenderer.setColor(Color.CYAN);
		shapeRenderer.rect(0,0, 200,200);
		shapeRenderer.line(0, (height/5)*4, width, (height/5)*4);
		
		//shapeRenderer.rect(figure.getX(),figure.getY() , figure.getWidth(), figure.getHeight() );
		shapeRenderer.end();*/
	}

	private void updateGameOver(float delta) {
		// TODO Auto-generated method stub
		
	}

}
