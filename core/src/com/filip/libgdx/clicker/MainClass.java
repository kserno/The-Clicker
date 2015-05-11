package com.filip.libgdx.clicker;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.filip.libgdx.clicker.helpers.AssetLoader;
import com.filip.libgdx.clicker.screens.Menu;

public class MainClass extends Game{
	SpriteBatch batch;
	Texture img;
	
	public MainClass() {
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		int height = Gdx.graphics.getHeight();
		int width = Gdx.graphics.getWidth();
		AssetLoader.load(width, height);
		setScreen(new Menu(width, height, this));
		
	}
}
