package com.perfectplay.org;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/* 
 * FractalControls is a GUI to control fractal parameters.
 * Written By: Hector Medina-Fetterman
 * Date: 12/7/2013
 */
public class HTreeControls extends Table implements FractalController{
	private Skin skin;
	
	public final Slider iterations;
	public final Slider width;
	public final Slider height;
	public final Slider angle;
	
	private Label label1;
	private Label label2;
	private Label label3;
	private Label label4;
	
	private int val1; 
	private int val2;
	private int val3;
	private int val4;
	//instantiates all the required objects for the GUI
	public HTreeControls(Skin skin){
		super(skin);
		this.skin = skin;
		this.iterations = new Slider(0, 15, 1, false, skin);
		this.width = new Slider(0,300,1, false, skin);
		this.height = new Slider(0,300,1, false, skin);
		this.angle = new Slider(0,270,1, false, skin);
		this.width.setValue(50);
		this.height.setValue(150);
		this.iterations.setValue(11);
		this.angle.setValue(90);
		this.setupGUI();
	}
	
	//populates the stage with all the Scene2d objects
	protected void setupGUI(){
		this.row();
		this.add("Iterations: ").padLeft(10);
		this.add(this.iterations);
		this.label1 = new Label(this.iterations.getValue()+"", skin);
		this.add(label1).padLeft(10).width(100).center();
		
		this.row();
		this.add("Angle: ").padLeft(10);
		this.add(this.angle);
		this.label4 = new Label(this.angle.getValue()+"°", skin);
		this.add(label4).padLeft(10).width(100).center();
		
		this.row();
		this.add("Width: ").padLeft(10);
		this.add(this.width);
		this.label2 = new Label(this.width.getValue()+"", skin);
		this.add(label2).padLeft(10).width(100).center();
		
		this.row();
		this.add("Height: ");
		this.add(this.height);
		this.label3 = new Label(this.height.getValue()+"", skin);
		this.add(label3).padLeft(10).width(100).center();
	}
	
	@Override
	public void act(float delta){
		//act is called when a member of the stage is changed. Update the fractal tree with new information
		super.act(delta);
		if(val1 != (int)this.iterations.getValue() || val2 != (int)this.width.getValue() || val3 != (int)this.height.getValue() || val4 != (int)this.angle.getValue()){
			val1 = (int)this.iterations.getValue();
			val2 = (int)this.width.getValue();
			val3 = (int)this.height.getValue();
			val4 = (int)this.angle.getValue();
			this.label1.setText((int)this.iterations.getValue()+"");
			this.label2.setText((int)this.width.getValue()+"");
			this.label3.setText((int)this.height.getValue()+"");
			this.label4.setText((int)this.angle.getValue()+"°");
			FractalTrees.setTree(new HTree((int)this.iterations.getValue(), 
										  (int)this.angle.getValue(), 
										  (int)this.width.getValue(),
										  (int)this.height.getValue(), 
										  Color.valueOf("D4E576"), 
										  Color.valueOf("126845")));
		}
	}
}
