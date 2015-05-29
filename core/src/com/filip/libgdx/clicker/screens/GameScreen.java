package com.filip.libgdx.clicker.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.filip.libgdx.clicker.gameworld.GameRenderer;
import com.filip.libgdx.clicker.gameworld.GameWorld;
import com.filip.libgdx.clicker.helpers.InputHandler;

public class GameScreen implements Screen {
	
	private GameWorld world;
	private GameRenderer renderer;
	private float gameSpeed;
	private float runTime;
	
	public GameScreen(int width, int height) {
		world = new GameWorld(width, height);
		renderer = new GameRenderer(world);
		Gdx.input.setInputProcessor(new InputHandler(world));
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		gameSpeed += delta/6;
		runTime += delta;
		world.update(delta,gameSpeed,runTime);
		renderer.update(delta,gameSpeed,runTime);
		
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
