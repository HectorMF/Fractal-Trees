package com.perfectplay.org;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

/* 
 * A simple static method to create a stage.
 * Written By: Hector Medina-Fetterman
 * Date: 12/7/2013
 */
public class StageComposer {
	public static void compose(Stage stage, Skin skin){
		Table table = new Table(skin);
		Window window = new Window("Controls",skin);
		table.setFillParent(true);
		table.align(Align.left + Align.top);
		window.add(new FractalControls(skin));
		table.padLeft(10);
		table.padTop(10);
		table.add(window);
		stage.addActor(table);
	}

}