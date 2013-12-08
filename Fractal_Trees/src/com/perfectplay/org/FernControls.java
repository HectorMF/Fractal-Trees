package com.perfectplay.org;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class FernControls extends Table implements FractalController{
	private Skin skin;
	
	public final Slider iterations;
	public final Slider width;
	public final Slider height;
	public final Slider angle;
	public final Slider branchScaling;
	public final Slider branchAngle;
	
	private Label label1;
	private Label label2;
	private Label label3;
	private Label label4;
	private Label label5;
	private Label label6;
	
	private int val1; 
	private int val2;
	private int val3;
	private int val4;
	private int val5;
	private float val6;
	
	//instantiates all the required objects for the GUI
	public FernControls(Skin skin){
		super(skin);
		this.skin = skin;
		this.iterations = new Slider(0, 10, 1, false, skin);
		this.width = new Slider(0,300,1, false, skin);
		this.height = new Slider(0,300,1, false, skin);
		this.angle = new Slider(-90,90,1, false, skin);
		this.branchAngle = new Slider(0, 90, 1, false, skin);
		this.branchScaling = new Slider(.3f,.7f,.1f,false,skin);
		this.width.setValue(30);
		this.height.setValue(150);
		this.iterations.setValue(8);
		this.angle.setValue(-6);
		this.branchAngle.setValue(60);
		this.branchScaling.setValue(.5f);
		
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
		this.add("Curve: ").padLeft(10);
		this.add(this.angle);
		this.label4 = new Label(this.angle.getValue()+"°", skin);
		this.add(label4).padLeft(10).width(100).center();
		
		this.row();
		this.add("Seperation: ").padLeft(10);
		this.add(this.branchAngle);
		this.label5 = new Label(this.branchAngle.getValue()+"°", skin);
		this.add(label5).padLeft(10).width(100).center();
		
		this.row();
		this.add("Scaling: ").padLeft(10);
		this.add(this.branchScaling);
		this.label6 = new Label(this.branchScaling.getValue()+"°", skin);
		this.add(label6).padLeft(10).width(100).center();
		
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
		if(val1 != (int)this.iterations.getValue() || val2 != (int)this.width.getValue() || val3 != (int)this.height.getValue() || 
		   val4 != (int)this.angle.getValue() || val5 != (int)this.branchAngle.getValue() || val6 != this.branchScaling.getValue()){
			val1 = (int)this.iterations.getValue();
			val2 = (int)this.width.getValue();
			val3 = (int)this.height.getValue();
			val4 = (int)this.angle.getValue();
			val5 = (int)this.branchAngle.getValue();
			val6 = this.branchScaling.getValue();
			this.label1.setText((int)this.iterations.getValue()+"");
			this.label2.setText((int)this.width.getValue()+"");
			this.label3.setText((int)this.height.getValue()+"");
			this.label4.setText((int)this.angle.getValue()+"°");
			this.label5.setText((int)this.branchAngle.getValue()+"°");
			this.label6.setText(this.branchScaling.getValue()+"°");
			FractalTrees.setTree(new Fern((int)this.iterations.getValue(), 
										  (int)this.angle.getValue(), 
										  (int)this.width.getValue(),
										  (int)this.height.getValue(),
										  (int)this.branchAngle.getValue(),
										  this.branchScaling.getValue(),
										  Color.valueOf("D4E576"), 
										  Color.valueOf("126845")));
		}
	}
}
