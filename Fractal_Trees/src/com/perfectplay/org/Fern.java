package com.perfectplay.org;

import java.util.ArrayList;
import java.util.Collections;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Fern extends Fractal{
	//a list of all branches in the tree
	private ArrayList<Branch> branches;
	
	private int levels;
	private int rotation;

	private Color start;
	private Color end;
	private int branchAngle;
	private float branchScaling;
	
	
	public Fern(int levels, int rotation, int start_width,  int start_height, int branchAngle, float branchScaling, Color start, Color end){
		branches = new ArrayList<Branch>();
		//create the trunk
		Branch trunk = new Branch(0, Branch.Center,Gdx.graphics.getWidth()/2, 0, start_width, start_height, 0, start);
		branches.add(trunk);
		this.start = start;
		this.end = end;
		this.levels = levels;
		this.rotation = rotation;
		this.branchAngle = branchAngle;
		this.branchScaling = branchScaling;
		calculateTree(trunk,0);
		Collections.sort(branches);
	}
	
	//recursive function used to calculate each iteration
	private void calculateTree(Branch branch, int level){
		if(level >= levels) return;
		
		int width = (int) ((branch.getWidth() * branchScaling)  +.5);
		int height = (int) ((branch.getHeight() * branchScaling) + .5);
		Branch b = branch;
		Vector2 center = b.getCenterPosition();
		int rot =branch.getRotation() + rotation;
		b = new Branch(level, Branch.Center, center.x,center.y,width, height,rot - branchAngle,start.cpy().lerp(end.cpy(), level/(float)levels));
		branches.add(b);
		calculateTree(b,level + 1);
		b = new Branch(level, Branch.Center, center.x,center.y,width, height,rot + branchAngle,start.cpy().lerp(end.cpy(), level/(float)levels));
		branches.add(b);
		calculateTree(b,level + 1);
		b = new Branch(level, Branch.Center, center.x,center.y,width,(int)( branch.getHeight()*.7), rot,start.cpy().lerp(end.cpy(), level/(float)levels));
		branches.add(b);
		calculateTree(b,level + 1);
		
	}
	
	//render all branches of the tree
	public void draw(ShapeRenderer renderer){
		for(int i = 0; i < branches.size(); i ++){
			branches.get(i).drawRoundedRectangle(renderer);
		}
	}
}
