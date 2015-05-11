package com.filip.libgdx.clicker.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.filip.libgdx.clicker.MainClass;
import com.filip.libgdx.clicker.helpers.AssetLoader;

public class Menu implements Screen{
	
	private OrthographicCamera cam;
	private SpriteBatch batcher;
	private SpriteDrawable sdPlay, sdHiscore;
	private ImageButton imgbPlay, imgbHiscore;
	private Stage stage;
	private Table table = new Table();
	
	
	public Menu(final int width, final int height, final MainClass game) {
		cam = new OrthographicCamera();
		cam.setToOrtho(true, width, height);
		
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		
		sdPlay = AssetLoader.sdPlay;
	    sdHiscore = AssetLoader.sdHiscore;
	    
	    stage = new Stage(new ScreenViewport(cam));
	    Gdx.input.setInputProcessor(stage);
	    stage.clear();
	    
	    imgbPlay = new ImageButton(sdPlay);
	    imgbPlay.setPosition(width/2 - width/8, height/ 3 *2);
	    imgbPlay.addListener(new InputListener() {
	    	public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new GameScreen(width, height));
                return true;
            }
	    });
	
		imgbHiscore = new ImageButton(sdHiscore);
		imgbHiscore.setPosition(width/2 - width/8, height/3 );
		imgbHiscore.addListener(new InputListener() {
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				game.setScreen(new HiscoreScreen(width, height));
				return true;
			}
		});
		table.add(imgbPlay, imgbHiscore);
		stage.addActor(table);
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    
	    batcher.begin();
	    batcher.enableBlending();
	    imgbPlay.draw(batcher, 50f);
	    //imgbHiscore.draw(batcher, 50f);
	    batcher.end();
	    
	    
	    
		
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
