package com.filip.libgdx.clicker.gameobjects;

public class GameObjectHandler {
	
	private Obstacle[] obs;
	private Figure figure;
	private Boost boost;
	private int width, height;
	
	public GameObjectHandler(int width, int height) {
		this.width = width;
		this.height = height;
		obs = new Obstacle[3];
		figure = new Figure(width/10,height/4, width/10, height/4);
		
	}
	
	public void update(float delta) {
		// update all gameobjects
		for (int i=0; i<obs.length; i++) {
			if (obs[i]!=null) obs[i].update(delta);			
		}
		figure.update(delta);
		
	}
	
	public Obstacle[] getObs() {
		return obs;
	}
	
	public Figure getFigure() {
		return figure;
	}
	
	
	
	
	
}
