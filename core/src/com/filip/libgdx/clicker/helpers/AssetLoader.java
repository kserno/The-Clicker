package com.filip.libgdx.clicker.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.filip.libgdx.clicker.gameobjects.Figure;

public class AssetLoader {
	
	private static final int FRAME_COLS= 5;
	private static final int FRAME_ROWS=2;
	
	public static Animation figureAnimation;	
	public static TextureRegion[] tr;
	
	public static SpriteDrawable sdPlay, sdHiscore;
	
	public static void load(int width, int height) {
		Texture texture = new Texture(Gdx.files.internal("data/play.png"));
		Sprite sprite = new Sprite(texture);
		sprite.setSize(width/4, height/10);
		sprite.flip(false,  true);
		sdPlay = new SpriteDrawable(sprite);
		
		texture = new Texture(Gdx.files.internal("data/hiscores.png"));
		sprite = new Sprite(texture);
		sprite.setSize(width/4, height/10);
		sprite.flip(false,  true);
		sdHiscore = new SpriteDrawable(sprite);
		
		texture = new Texture(Gdx.files.internal("data/figureanimation.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		tr = new TextureRegion[(FRAME_COLS*FRAME_ROWS)];
		for (int i = 0; i<FRAME_COLS; i++) {
			tr[i] = new TextureRegion(texture,180*i,32,180,211 );
			tr[i+5] = new TextureRegion(texture,180*i,251,180,211);
			tr[i].flip(false, true);
			tr[i+5].flip(false, true);
		}
		
		figureAnimation = new Animation(0.2f, tr);
		figureAnimation.setPlayMode(PlayMode.LOOP);
		
		
		
		
		
	}

}
