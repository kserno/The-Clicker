package com.filip.libgdx.clicker.networklayer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.async.AsyncTask;

public class reqHiscores implements AsyncTask<int[]>{
	
	
	private static final String cUrl = "http://www.sollmin.tk/api_theclicker/index.php?do=get";
	
	private HttpURLConnection conn;
	private StringBuilder sb;
	private BufferedReader br;
	private String sJson;

	@Override
	public int[] call() throws Exception {
		// TODO Auto-generated method stub
		
		
		URL url = new URL(cUrl);
		conn = (HttpURLConnection) url.openConnection();
		br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UFT-8"));
		sb = new StringBuilder();
		String row = null;
		
		while ((row= br.readLine()) != null) {
			sb.append(row+"/n");
		}
		sJson = sb.toString();
		Json json = new Json();
		
		
		
		
		
		
		return null;
	}

}
