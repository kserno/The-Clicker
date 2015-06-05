package com.filip.libgdx.clicker.helpers;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.filip.libgdx.clicker.gameworld.GameWorld;
import com.filip.libgdx.clicker.gameworld.GameWorld.GameState;

public class InputHandler implements InputProcessor{

	private GameWorld world;
	
	public InputHandler(GameWorld world) {
		// TODO Auto-generated constructor stub
		this.world = world;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		if (keycode== 19 && world.getCurrentState() == GameState.RUNNING) {
			world.keyUp();
		}
		if (keycode==20 && world.getCurrentState() == GameState.RUNNING ) {
			world.keyDown();
		}
		if (world.getCurrentState() == GameState.READY) {
			world.start();
		}
		if (world.getCurrentState() == GameState.GAMEOVER || world.getCurrentState() == GameState.HISCORE) {
			world.restart();
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		if (Gdx.app.getType() == ApplicationType.Android) {
			// TODO
		}
		return false;
		
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
