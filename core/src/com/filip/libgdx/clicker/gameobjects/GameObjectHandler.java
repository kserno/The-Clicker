package com.filip.libgdx.clicker.gameobjects;

import java.util.Random;

import com.badlogic.gdx.math.Intersector;
import com.filip.libgdx.clicker.gameworld.GameWorld;
import com.filip.libgdx.clicker.helpers.AssetLoader;

public class GameObjectHandler {
	
	private Obstacle obstacle;
	private Figure figure;
	private Boost boost;
	private int width, height;
	private Random r;
	private Boolean isBoostActive;
	private Ground ground;
	private GameWorld world;
	private Boolean isObsSpawned= false;
	private int gap;
	private Hole hole;
	
	public GameObjectHandler(int width, int height, GameWorld world) {
		this.width = width;
		this.height = height;
		figure = new Figure(width/7,height/32*22,width/10,height/6);
		ground = new Ground(0, height/32*22+height/6, width, height/30);
		r= new Random();
		this.world = world;
		isBoostActive = false;
		gap = height/6/2;
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
		figure.update(delta,ground);
		
		if (isBoostActive && boost!=null) boost.update(delta);
		if (obstacle!=null) obstacle.update(delta);
		if (hole!=null) hole.update(delta, gameSpeed);
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
		System.out.println(figure.getY());
		if (isBoostActive&& Intersector.overlaps(boost.getBoundingRect(), figure.getBoundingRect())) {
			if (boost instanceof DoubleJump) {
				world.doubleJumpGained();	
			}
			if (boost instanceof Coin) {
				world.coinGained();
				AssetLoader.coin.play();
			}
			boost = null;
			isBoostActive = false;
		}
		if (isBoostActive && boost.getX()+boost.getWidth()<0) {
			boost = null;
			isBoostActive = false;
		}
		if (hole!=null && figure.getX() > hole.getX() && figure.getX() + figure.getWidth() < hole.getX() + hole.getWidth() && hole.getY() >= figure.getY()) figure.die();
		if (obstacle!=null && Intersector.overlaps(obstacle.getBoundingRect(), figure.getBoundingRect())) figure.die();
		if (obstacle!=null && obstacle.getX()+obstacle.getWidth()<0) obstacle= null;
		
		if (hole!=null &&hole.getX()+hole.getWidth() <0) hole =null;
		
	}

	private void spawnObjects(float delta, float runTime, float gameSpeed, float runningTime) {
		// TODO Auto-generated method stub
		if ((int)(runningTime%(10f-gameSpeed)) == 0 && !isBoostActive) { // handles spawning boosts
			isBoostActive = true;
			switch(r.nextInt(2)) {
			case 0 :
				boost = new Coin(ground,width,height, gameSpeed,gap);
				break;
			case 1 :
				boost = new DoubleJump(ground,width,height, gameSpeed,gap);
			break;			
			}
		}
				 
		
		int x = (figure.getOneMoreJump()? 4 :3);
		if (obstacle ==null && hole==null) {
			switch (r.nextInt(x)) {
				case 0:
					obstacle = new LowerObstacle(ground, gameSpeed, height);
					break;
				case 1:
					obstacle = new UpperObstacle(ground, gap, gameSpeed); // TODO
					break;
				
				case 2:
					hole = new Hole(ground,gameSpeed,width); // TODO
					break;
				case 3:
					obstacle= new DoubleObstacle(ground, width, height, gameSpeed);
					break;
			
			}
		}
	}

	public Obstacle getObstacle() {
		return obstacle;
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
	
	public Boolean getIsHoleActive() {
		if (hole==null) return false;
		return true;
	}
	
	public Hole getHole() {
		return hole;
	}

	public void restart() {
		// TODO Auto-generated method stub
		obstacle = null;
		hole = null;
		boost = null;
		isBoostActive = false;
		figure.restart();
		
	}
	
}
