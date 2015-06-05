package com.filip.libgdx.clicker.helpers;

import jdk.internal.org.objectweb.asm.tree.JumpInsnNode;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
	
	public static Sprite gBackground;
	
	public static Animation coinAnimation;
	
	public static TextureRegion[] tr2;
		
	public static Preferences prefs;
	
	public static TextureRegion uObs, lObs, dObs;
	
	public static Sound coin;
	
	public static BitmapFont font, shadow;
	
	public static Animation jumpAnimation;
	public static Animation idleAnimation;
	
	public static void load(int width, int height) {
        prefs = Gdx.app.getPreferences("TheClicker");
		if (!prefs.contains("coins")) {
			prefs.putInteger("coins", 0);
		}
		
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
			tr[i] = new TextureRegion(texture,280*i,44,280,343 );
			tr[i+5] = new TextureRegion(texture,280*i,389,280,331);
			tr[i].flip(false, true);
			tr[i+5].flip(false, true);
		}
		
		figureAnimation = new Animation(0.1f, tr);
		figureAnimation.setPlayMode(PlayMode.LOOP);
		
		texture = new Texture(Gdx.files.internal("data/background.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		gBackground= new Sprite(texture);
		gBackground.flip(false, true);
		gBackground.setSize(texture.getWidth(), height);
		
		texture = new Texture(Gdx.files.internal("data/coin.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		tr2 = new TextureRegion[10];
		for (int i=0; i<10; i++) {
			tr2[i] = new TextureRegion(texture, (texture.getWidth()/10)*i, 0, texture.getWidth()/10, texture.getHeight() );
		}
		
		coinAnimation=  new Animation(0.07f, tr2);
		coinAnimation.setPlayMode(PlayMode.LOOP);
		
		
		TextureRegion[] tr3 = new TextureRegion[8];
		texture = new Texture(Gdx.files.internal("data/jump.png"));
		for (int i=0; i<2; i++) {
			for (int i2=0; i2<4; i2++) {
				tr3[i*4+i2]= new TextureRegion(texture, (texture.getWidth()/4)*i2, (texture.getHeight()/2)*i, texture.getWidth()/4, texture.getHeight()/2 );
				tr3[i*4+i2].flip(false, true);
			}
		}
		
		jumpAnimation = new Animation(0.04f, tr3);
		jumpAnimation.setPlayMode(PlayMode.LOOP);
		
		texture = new Texture(Gdx.files.internal("data/idle.png"));
		TextureRegion[] tr4 = new TextureRegion[2];
		tr4[0]=new TextureRegion(texture,0, 0,texture.getWidth()/2, texture.getHeight());
		tr4[0].flip(false, true);
		tr4[1] = new TextureRegion(texture, texture.getWidth()/2,0, texture.getWidth()/2, texture.getHeight());
		tr4[1].flip(false, true);
		
		idleAnimation = new Animation(0.2f, tr4);
		idleAnimation.setPlayMode(PlayMode.LOOP);
		
		texture = new Texture(Gdx.files.internal("data/spike1.png"));
		lObs = new TextureRegion(texture);
		lObs.flip(false, true);
		
		texture = new Texture(Gdx.files.internal("data/spike2.png"));
		uObs = new TextureRegion(texture);
		dObs = new TextureRegion(texture);
		dObs.flip(false , true);
		
		
		coin = Gdx.audio.newSound(Gdx.files.internal("data/coin.wav"));
		
		font = new BitmapFont(Gdx.files.internal("data/text.fnt"));
		font.setScale(.4f, -.4f);
		shadow = new BitmapFont(Gdx.files.internal("data/shadow.fnt"));
		shadow.setScale(.4f, -.4f);
	}
	
	public static int getCoins() {
		return prefs.getInteger("coins");
	}

	public static void addCoin() {
		// TODO Auto-generated method stub
		int val = getCoins();
		prefs.putInteger("coins", val);
		prefs.flush();
	}

	public static int getHiscore() {
		// TODO Auto-generated method stub
		return prefs.getInteger("hiscore");
	}
	
	public static void setHiscore(int val) {
		prefs.putInteger("hiscore", val);
		prefs.flush();
	}
		
	
	private void dispose() {
		// TODO Auto-generated method stub
		font.dispose();
		coin.dispose();
		shadow.dispose();
	}
	

}
