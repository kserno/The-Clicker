package com.filip.libgdx.clicker.desktop;

import java.util.Formatter.BigDecimalLayoutForm;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.filip.libgdx.clicker.MainClass;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "The Clicker";
		config.width=800;
		config.height=600;
		config.addIcon("data/icon.png", Files.FileType.Internal);
		new LwjglApplication(new MainClass(), config);
	}
}
