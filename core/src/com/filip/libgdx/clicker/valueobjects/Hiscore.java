package com.filip.libgdx.clicker.valueobjects;

public class Hiscore {
	
	private String username;
	private int score;
	
	public Hiscore(String username, int score) {
		this.username= username;
		this.score = score;
	}
	
	public String getUsername() {
		return username;
	}
	
	public int getScore() {
		return score;
	}

}
