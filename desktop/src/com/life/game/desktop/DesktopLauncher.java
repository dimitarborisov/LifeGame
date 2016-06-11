package com.life.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.life.game.LifeGdxGame;

public class DesktopLauncher {
	 static int WINDOW_HEIGHT = 500;
	 static int WINDOW_WIDTH = 500;

	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		
		cfg.title = "Life";
		cfg.height = WINDOW_HEIGHT;
		cfg.width = WINDOW_WIDTH;
		
		new LwjglApplication(new LifeGdxGame(), cfg);
	}
}
