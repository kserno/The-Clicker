package com.filip.libgdx.clicker.gameobjects;

import java.util.Random;

import com.badlogic.gdx.math.Intersector;
import com.filip.libgdx.clicker.gameworld.GameWorld;

public class GameObjectHandler {
	
	private Obstacle[] obs;
	private Figure figure;
	private Boost boost;
	private int width, height;
	private Random r;
	private Boolean isBoostActive;
	private Ground ground;
	private GameWorld world;
	private Boolean isObsSpawned= false;
	
	public GameObjectHandler(int width, int height, GameWorld world) {
		this.width = width;
		this.height = height;
		obs = new Obstacle[3];
		figure = new Figure(width/7,height/32*22,width/10,height/7);
		ground = new Ground(0, height/32*22+height/7, width, height/30);
		r= new Random();
		this.world = world;
		isBoostActive = false;
	}
	
	public void update(float delta, float runTime,float gameSpeed, float runningTime) {
		// update all gameobjects
		//spawn object in some exact time
		
		switch(world.getCurrentState()) {
		case RUNNING :
			updateRunning(delta,runTime,gameSpeed,runningTime);
		break;
		case READY :
			updateReady(delta,runTime,gameSpeed);
		break;
		case PAUSE :
			updatePause(delta,runTime,gameSpeed);
		break;
		case GAMEOVER:
			updateGameover(delta,runTime,gameSpeed);
		break;
		case HISCORE :
			updateHiscore(delta,runTime,gameSpeed);
		break;
		}
		
	}
	
	private void updateRunning(float delta, float runTime, float gameSpeed,float runningTime) {
		// TODO Auto-generated method stub
		spawnObjects(delta, runTime, gameSpeed,runningTime);
		
		figure.update(delta);
		if (isBoostActive) boost.update(delta);
		for (int i=0; i<obs.length; i++) {
			if (obs[i]!=null) obs[i].update(delta);
		}
		collisionCheck();
	}

	private void updateReady(float delta, float runTime, float gameSpeed) {
		// TODO Auto-generated method stub
		
	}

	private void updatePause(float delta, float runTime, float gameSpeed) {
		// TODO Auto-generated method stub
		
	}

	private void updateGameover(float delta, float runTime, float gameSpeed) {
		// TODO Auto-generated method stub
		
	}

	private void updateHiscore(float delta, float runTime, float gameSpeed) {
		// TODO Auto-generated method stub
		
	}

	private void collisionCheck() {
		// TODO Auto-generated method stub
		if (isBoostActive&& Intersector.overlaps(boost.getBoundingRect(), figure.getBoundingRect())) {
			if (boost instanceof Freeze) world.freeze();	
			if (boost instanceof Coin) world.coinGained();
			boost = null;
			isBoostActive = false;
		}
		if (isBoostActive && boost.getX()+boost.getWidth()<0) {
			boost = null;
			isBoostActive = false;
		}
		for (int i =0; i<obs.length; i++) {
			if (obs[i]!=null && Intersector.overlaps(obs[i].getBoundingRect(), figure.getBoundingRect())) figure.die();
			if (obs[i]!=null && obs[i].getX()+obs[i].getWidth()<0) obs[i]= null;
		}
	}

	private void spawnObjects(float delta, float runTime, float gameSpeed, float runningTime) {
		// TODO Auto-generated method stub
		if ((int)(runningTime%(10f-gameSpeed)) == 0 && !isBoostActive) { // handles spawning boosts
			isBoostActive = true;
			switch(r.nextInt(2)) {
			case 0 :
				boost = new Coin(width,ground.getY()-figure.getHeight()*2,width/15, width/15);
				break;
			case 1 :
				boost = new Freeze(width,ground.getY()-figure.getHeight()*2,width/15, width/15);
			break;			
			}
		}
		int x=0;
		for (int i =0; i<obs.length; i++) {
			if (obs[i]==null) {
				// TODO
				x=i;
				break;
			}
		}
		obs[x] = new LowerObstacle(width,ground.getY()-figure.getHeight()/3*2, width/10, width/10, gameSpeed); 
		
		/*if (runTime%(7f-gameSpeed)==0) { // handles spawning obstacles
			switch (r.nextInt(3)) {
			case 0:
				for (int i =0; i<obs.length; i++) {
					if (obs[i]!=null) {
							obs[i] = new LowerObstacle(width,ground.getX(), width/15, figure.getHeight()/3*2); // TODO
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
			
		}*/
		
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
	
	public Ground getGround() {
		return ground;
	}
	 
	public Boost getBoost() {
		return boost;
	}
	
	
}
