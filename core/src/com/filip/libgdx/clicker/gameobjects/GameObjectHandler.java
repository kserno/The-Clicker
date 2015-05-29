package com.filip.libgdx.clicker.gameobjects;

import java.util.Random;

public class GameObjectHandler {
	
	private Obstacle[] obs;
	private Figure figure;
	private Boost boost;
	private int width, height;
	private Random r;
	private Boolean isBoostActive;
	
	public GameObjectHandler(int width, int height) {
		this.width = width;
		this.height = height;
		obs = new Obstacle[3];
		figure = new Figure(50,50,50,100);
		r= new Random();
		
	}
	
	public void update(float delta, float runTime,float gameSpeed) {
		// update all gameobjects
		//spawn object in some exact time
		//spawnObjects(delta, runTime, gameSpeed);
		
		
		
		for (int i=0; i<obs.length; i++) {
			if (obs[i]!=null) obs[i].update(delta);			
		}
		figure.update(delta);
		
	}
	
	private void spawnObjects(float delta, float runTime, float gameSpeed) {
		// TODO Auto-generated method stub
		if (runTime%(10f-gameSpeed) == 0 && !isBoostActive) { // handles spawning boosts
			isBoostActive = true;
			switch(r.nextInt(2)) {
			case 0 :
				boost = new Coin(width,height/3,width/25, height/10);
				break;
			case 1 :
				boost = new Freeze(width,height/3,width/25, height/10);
			break;			
			}
		}
		
		if (runTime%(7f-gameSpeed)==0) { // handles spawning obstacles
			switch (r.nextInt(3)) {
			case 0:
				for (int i =0; i<obs.length; i++) {
					if (obs[i]!=null) {
							obs[i] = new LowerObstacle(); // TODO
						break;
					}
				}
				break;

			case 1:
				for (int i =0; i<obs.length; i++) {
					if (obs[i]!=null) {
							obs[i] = new UpperObstacle(); // TODO
						break;
					}
				}
				break;
			case 2:
				for (int i =0; i<obs.length; i++) {
					if (obs[i]!=null) {
							obs[i] = new DoubleObstacle(); // TODO
						break;
					}
				}
				break;
			}
			
		}
		
	}

	public Obstacle[] getObs() {
		return obs;
	}
	
	public Figure getFigure() {
		return figure;
	}
	
	public Boolean getIsBoostActive() {
		return isBoostActive;
	}
	
	
	
	
}
