package com.perfectplay.org;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Fractal Tree Test";
		cfg.useGL20 = false;
		cfg.width = 480*2;
		cfg.height = 320*2;
		
		new LwjglApplication(new FractalTrees(), cfg);
	}
}
