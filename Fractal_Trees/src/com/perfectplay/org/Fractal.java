package com.perfectplay.org;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/* 
 * Base fractal class used to render all fractals
 * Written By: Hector Medina-Fetterman
 * Date: 12/8/2013
 */
public abstract class Fractal {
	//render all branches of the tree
	public abstract void draw(ShapeRenderer renderer);
}
