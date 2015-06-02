package com.filip.libgdx.clicker.helpers;

public class Hiscore {
	
	private String username;
	private int score;
	
	public Hiscore(String username, int score) {
		this.username = username;
		this.score = score;
		
	}
	
	public int getScore() {
		return score;
	}
	
	public String getUsername() {
		return username;
	}

}
