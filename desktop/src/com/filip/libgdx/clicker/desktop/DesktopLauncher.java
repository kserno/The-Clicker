package com.filip.libgdx.clicker.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.filip.libgdx.clicker.MainClass;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 400;
		config.width = 400;
		config.title = "The Clicker";
		//config.addIcon(, fileType);
		new LwjglApplication(new MainClass(), config);
	}
}
