package com.filip.libgdx.clicker.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class ShopScreen implements Screen{
	
	private ImageButton left,right;
	private ImageButton noAds, oneMoreHealth ;
	private Stage stage;
	private Table table;
	private SpriteBatch batcher;
	private OrthographicCamera cam;

	public ShopScreen(int width, int height) {
		cam = new OrthographicCamera();
		cam.setToOrtho(true, width, height);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		
		stage = new Stage(new ScreenViewport(cam));
		Gdx.input.setInputProcessor(stage);
		stage.clear();
		
		//left = new ImageButton();
		//left.setPosition(, y);
		
		
				
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
