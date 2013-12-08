package com.perfectplay.org;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/* Inspired by: http://andrew-hoyer.com/experiments/fractals/
 * FractalTrees is the applicationListener that handles rendering and updating
 * of the tree and GUI.
 * Written By: Hector Medina-Fetterman
 * Date: 12/7/2013
 */
public class FractalTrees implements ApplicationListener {
	private ShapeRenderer renderer;
	private SpriteBatch batch;
	
	private Skin skin;
	private Stage stage;
	
	private static Fractal tree;
	
	@Override
	public void create() {		
		//instantiate Stage and batches.
		this.batch = new SpriteBatch();
		this.renderer = new ShapeRenderer();
		this.stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false, this.batch);
		this.skin = new Skin(Gdx.files.internal("data/buttons.json"));
		Gdx.input.setInputProcessor(this.stage);
		StageComposer.compose(stage, skin);
	}
	
	// Set the tree to be rendered statically. 
	// Allows the controller to update the program simply.
	public static void setTree(Fractal t){
		tree = t;
	}
	
	@Override
	public void dispose() {
		renderer.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		this.stage.act();
		renderer.setProjectionMatrix(stage.getCamera().combined);
		
		//render the tree
		renderer.begin(ShapeType.Filled);
		tree.draw(renderer);
		renderer.end();
		
		//render the GUI
		renderer.begin(ShapeType.Line);
		stage.draw();
		renderer.end();
	}

	@Override
	public void resize(int width, int height) {
		stage.setViewport(width, height, false);
	}

	@Override
	public void pause() { }

	@Override
	public void resume() { }
}
