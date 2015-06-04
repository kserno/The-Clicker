package com.filip.libgdx.clicker.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
	
	protected Vector2 position;
	protected Vector2 velocity;
	
	protected int width, height;
	
	protected Rectangle boundingRect;
	
	public GameObject(float x, float y, int width, int height) {
		position = new Vector2(x,y);
		velocity = new Vector2(0,0);
		this.width = width;
		this.height = height;
		boundingRect = new Rectangle(x, y, width, height);
				
	}
	
	protected void update(float delta) {
		position.add(velocity.cpy().scl(delta));
		boundingRect.setPosition(position);
		boundingRect.setHeight(height);
		
	}
	
	public float getX() {
		return position.x;
	}
	
	public float getY() {
		return position.y;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public Rectangle getBoundingRect() {
		return boundingRect;
	}
	
	public float getVel() {
		return velocity.x;
	}
	
}
