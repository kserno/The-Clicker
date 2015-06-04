package com.filip.libgdx.clicker.gameworld;

import org.omg.CORBA.portable.IDLEntity;

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
import com.filip.libgdx.clicker.gameobjects.DoubleObstacle;
import com.filip.libgdx.clicker.gameobjects.Figure;
import com.filip.libgdx.clicker.gameobjects.GameObjectHandler;
import com.filip.libgdx.clicker.gameobjects.Ground;
import com.filip.libgdx.clicker.gameobjects.LowerObstacle;
import com.filip.libgdx.clicker.gameobjects.Obstacle;
import com.filip.libgdx.clicker.gameobjects.UpperObstacle;
import com.filip.libgdx.clicker.helpers.AssetLoader;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class GameRenderer {
	
	private GameWorld myWorld;
	private OrthographicCamera cam;
	
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batcher;
	
	// Game Objects
	private Figure figure;	
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
	    drawBackground(delta, gameSpeed);
		
		drawGround();
		
		switch(myWorld.getCurrentState()) {
		case READY :
			updateReady(delta, runTime);
		break;
		case RUNNING :
			updateRunning(delta, runTime);
		break;
		case GAMEOVER :
			updateGameOver(delta, runTime);
		break;
		case HISCORE :
			updateHiscore(delta, runTime);
		break;
		}
		
	}

	private void drawGround() {
		// TODO Auto-generated method stub
		shapeRenderer.begin(ShapeType.Filled);	
		shapeRenderer.setColor(ground.getColor());
		shapeRenderer.rect(ground.getX(), ground.getY(), ground.getWidth(), ground.getHeight());
		if (handler.getIsHoleActive()) {
			shapeRenderer.setColor(109/255f, 208/255f,247/255f, 1);
			shapeRenderer.rect(handler.getHole().getX(), handler.getHole().getY(), handler.getHole().getWidth(), handler.getHole().getHeight());
		}
		shapeRenderer.end();
		
	}

	private void drawBackground(float delta, float gameSpeed) {		
		// TODO Auto-generated method stub
		 batcher.begin();
		if (background.getX()<0) background.setX(width);
		
		offsetX=bgSpeed * delta * gameSpeed;
		
		
		background.translateX(-width- offsetX);
		background.draw(batcher);
		background.translateX(width);
		background.draw(batcher);
		batcher.end();
	}

	private void updateHiscore(float delta, float runTime) {
		// TODO Auto-generated method stub
		batcher.begin();
		String str = "NEW HISCORE ! Your new hiscore is" + myWorld.getScore() +"Click to restart";
		AssetLoader.shadow.draw(batcher, str, 0, height/2);
		AssetLoader.font.draw(batcher, str, 0, height/2);
		TextureRegion temp = null; 
		
		if (handler.getObstacle()!=null && handler.getObstacle() instanceof UpperObstacle) {
			temp = AssetLoader.fSpikes[handler.getObstacle().getSpriteN()];
		} else if (handler.getObstacle()!=null && handler.getObstacle() instanceof LowerObstacle || handler.getObstacle() instanceof DoubleObstacle){
			temp = AssetLoader.spikes[handler.getObstacle().getSpriteN()];
		}
		
		if (handler.getObstacle()!=null) batcher.draw(temp, handler.getObstacle().getX(),handler.getObstacle().getY(),handler.getObstacle().getWidth(),handler.getObstacle().getHeight());
		
		
		if (handler.getIsBoostActive()) batcher.draw(coinAnimation.getKeyFrame(runTime), handler.getBoost().getX(), handler.getBoost().getY(), handler.getBoost().getWidth(), handler.getBoost().getHeight());
		
		batcher.end();
	}

	private void updateReady(float delta,float runTime) {
		// TODO Auto-generated method stub
		batcher.begin();
		String str = "Press any button";
		AssetLoader.shadow.draw(batcher, str, 0, height/2);
		AssetLoader.font.draw(batcher, str, 0, height/2);
		batcher.draw(AssetLoader.idleAnimation.getKeyFrame(runTime), figure.getX(), figure.getY(), figure.getWidth(), figure.getHeight());
		batcher.end();
	}

	private void updateRunning(float delta, float runTime) {
		// TODO Auto-generated method stub
		batcher.begin();
		batcher.enableBlending();
		if (!figure.getIsJumping() && !figure.getIsSliding()) {
			batcher.draw(figureAnimation.getKeyFrame(runTime),figure.getX(), figure.getY(), figure.getWidth(), figure.getHeight());
		} else if (figure.getIsJumping() || figure.getIsSliding()){
			batcher.draw(AssetLoader.jumpAnimation.getKeyFrame(runTime), figure.getX(),figure.getY(), figure.getWidth(), figure.getHeight());
		}		
		String score = myWorld.getScore() +"";
		AssetLoader.shadow.draw(batcher, score, width/2, 0);
		AssetLoader.font.draw(batcher,score,width/2, 0);
		
		TextureRegion temp = null; 
		
		if (handler.getObstacle()!=null && handler.getObstacle() instanceof UpperObstacle) {
			temp = AssetLoader.fSpikes[handler.getObstacle().getSpriteN()];
		} else if (handler.getObstacle()!=null && handler.getObstacle() instanceof LowerObstacle || handler.getObstacle() instanceof DoubleObstacle){
			temp = AssetLoader.spikes[handler.getObstacle().getSpriteN()];
		}
		
		if (handler.getObstacle()!=null) batcher.draw(temp, handler.getObstacle().getX(),handler.getObstacle().getY(),handler.getObstacle().getWidth(),handler.getObstacle().getHeight());
		
		
		if (handler.getIsBoostActive()) batcher.draw(coinAnimation.getKeyFrame(runTime), handler.getBoost().getX(), handler.getBoost().getY(), handler.getBoost().getWidth(), handler.getBoost().getHeight());
		batcher.end();
	}

	private void updateGameOver(float delta, float runTime) {
		// TODO Auto-generated method stub
		batcher.begin();
		String str = "Game Over your score is" + myWorld.getScore() +"Click to restart";
		AssetLoader.shadow.draw(batcher, str, 0, height/2);
		AssetLoader.font.draw(batcher, str, 0, height/2);
		TextureRegion temp = null; 
		
		if (handler.getObstacle()!=null && handler.getObstacle() instanceof UpperObstacle) {
			temp = AssetLoader.fSpikes[handler.getObstacle().getSpriteN()];
		} else if (handler.getObstacle()!=null && handler.getObstacle() instanceof LowerObstacle || handler.getObstacle() instanceof DoubleObstacle){
			temp = AssetLoader.spikes[handler.getObstacle().getSpriteN()];
		}
		
		if (handler.getObstacle()!=null) batcher.draw(temp, handler.getObstacle().getX(),handler.getObstacle().getY(),handler.getObstacle().getWidth(),handler.getObstacle().getHeight());
		
		
		if (handler.getIsBoostActive()) batcher.draw(coinAnimation.getKeyFrame(runTime), handler.getBoost().getX(), handler.getBoost().getY(), handler.getBoost().getWidth(), handler.getBoost().getHeight());
		
		batcher.end();
	}

}
