package com.filip.libgdx.clicker.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class AssetLoader {
	
	
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
	}

}
