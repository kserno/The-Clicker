package com.filip.libgdx.clicker.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.filip.libgdx.clicker.gameobjects.Boost;
import com.filip.libgdx.clicker.gameobjects.Figure;
import com.filip.libgdx.clicker.gameobjects.GameObjectHandler;
import com.filip.libgdx.clicker.gameobjects.Ground;
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
	
	private Sprite background;
	
	private float offsetX, bgSpeed;
	
	private Ground ground;
	
	private Boost boost;
	private TextureRegion[] spikes;
	
	private Animation coinAnimation;
	private GameObjectHandler handler;

	public GameRenderer(GameWorld world) {
		// TODO Auto-generated constructor stub
		myWorld = world;
		
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		bgSpeed= width/10;
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true, width, height);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		
		initGameObjects();
		loadAssets();
	}

	private void initGameObjects() {
		// TODO Auto-generated method stub
		figure = myWorld.getHandler().getFigure();
		obs = myWorld.getHandler().getObs();
		ground = myWorld.getHandler().getGround();
		handler = myWorld.getHandler();
	}

	private void loadAssets() {
		// TODO Auto-generated method stub
		// here i load sprites and stuff
		figureAnimation = AssetLoader.figureAnimation;	
		background = AssetLoader.gBackground;
		coinAnimation = AssetLoader.coinAnimation;
		spikes = AssetLoader.spikes;
	}
	
	public void update(float delta, float gameSpeed, float runTime) {
		//rendering 
		Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batcher.begin();
		drawBackground(delta, gameSpeed);
		batcher.enableBlending();
		if (!figure.getIsJumping()) {
			batcher.draw(figureAnimation.getKeyFrame(runTime),figure.getX(), figure.getY(), figure.getWidth()/2.0f, figure.getHeight()/2.0f, figure.getWidth(), figure.getHeight(),1,1, figure.getRotation());
		} else {
			batcher.draw(AssetLoader.jumpAnimation.getKeyFrame(runTime), figure.getX(),figure.getY(), figure.getWidth(), figure.getHeight());
		}		
		for (int i=0; i<handler.getObs().length; i++) {
			if (myWorld.getHandler().getObs()[i] !=null) batcher.draw(AssetLoader.spikes[0], myWorld.getHandler().getObs()[i].getX(),myWorld.getHandler().getObs()[i].getY(),myWorld.getHandler().getObs()[i].getWidth(),myWorld.getHandler().getObs()[i].getHeight());
		}
		batcher.draw(AssetLoader.idleAnimation.getKeyFrame(runTime), 20,20,50,100);
		batcher.end();
		
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(Color.WHITE);
		shapeRenderer.rect(figure.getBoundingRect().getX(),figure.getBoundingRect().getY(), figure.getBoundingRect().getWidth(), figure.getBoundingRect().getHeight());
		shapeRenderer.end();
		
		shapeRenderer.begin(ShapeType.Filled);	
		shapeRenderer.setColor(ground.getColor());
		shapeRenderer.rect(ground.getX(), ground.getY(), ground.getWidth(), ground.getHeight());
		shapeRenderer.end();
		
		switch(myWorld.getCurrentState()) {
		case READY :
			updateReady(delta);
		break;
		case RUNNING :
			updateRunning(delta, runTime);
		break;
		case GAMEOVER :
			updateGameOver(delta);
		break;
		case HISCORE :
			updateHiscore(delta);
		break;
		}
		
	}

	private void drawBackground(float delta, float gameSpeed) {
		// TODO Auto-generated method stub
		if (background.getX()<0) background.setX(width);
		
		offsetX=bgSpeed * delta * gameSpeed;
		
		
		background.translateX(-width- offsetX);
		background.draw(batcher);
		background.translateX(width);
		background.draw(batcher);
		
	}

	private void updateHiscore(float delta) {
		// TODO Auto-generated method stub
		
	}

	private void updateReady(float delta) {
		// TODO Auto-generated method stub
		
	}

	private void updateRunning(float delta, float runTime) {
		// TODO Auto-generated method stub
		/*shapeRenderer.begin(ShapeType.Filled);
		
		shapeRenderer.setColor(Color.CYAN);
		shapeRenderer.rect(0,0, 200,200);
		shapeRenderer.line(0, (height/5)*4, width, (height/5)*4);
		
		//shapeRenderer.rect(figure.getX(),figure.getY() , figure.getWidth(), figure.getHeight() );
		shapeRenderer.end();*/
		batcher.begin();
		for (int i=0; i<handler.getObs().length; i++) {
			if (handler.getObs()[i]!=null) batcher.draw(spikes[0], handler.getObs()[i].getX(),handler.getObs()[i].getY(),handler.getObs()[i].getWidth(),handler.getObs()[i].getHeight());
		}
		if (handler.getIsBoostActive()) batcher.draw(coinAnimation.getKeyFrame(runTime), handler.getBoost().getX(), handler.getBoost().getY(), handler.getBoost().getWidth(), handler.getBoost().getHeight());
		batcher.end();
	}

	private void updateGameOver(float delta) {
		// TODO Auto-generated method stub
		
	}

}
