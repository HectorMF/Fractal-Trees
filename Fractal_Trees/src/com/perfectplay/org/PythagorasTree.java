package com.perfectplay.org;

import java.util.ArrayList;
import java.util.Collections;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/* 
 * Trees are a collection of branches. Given a trunk, trees can be generated 
 * recursively.
 * Written By: Hector Medina-Fetterman
 * Date: 12/7/2013
 */
public class PythagorasTree extends Fractal {
	//a list of all branches in the tree
	private ArrayList<Branch> branches;
	
	private int levels;
	private int rotation;

	private Color start;
	private Color end;
	
	public PythagorasTree(int levels, int rotation, int start_width, int start_height, Color start, Color end){
		branches = new ArrayList<Branch>();
		//create the trunk
		Branch trunk = new Branch(0, Branch.Center,Gdx.graphics.getWidth()/2, 0, start_width, start_height, 0, start);
		branches.add(trunk);
		this.start = start;
		this.end = end;
		this.levels = levels;
		this.rotation = rotation;
		calculateTree(trunk,0);
		Collections.sort(branches);
	}
	
	//recursive function used to calculate each iteration
	private void calculateTree(Branch branch, int level){
		if(level >= levels) return;

		int lwidth = (int) (Math.cos(Math.toRadians(rotation))*(float)branch.getHeight());
		int rwidth = (int) (Math.sin(Math.toRadians(rotation))*(float)branch.getHeight());
		
		Branch branch_one = new Branch(level, Branch.Left, branch.vertices[3].x, branch.vertices[3].y, lwidth, lwidth, branch.getRotation() + rotation, start.cpy().lerp(end.cpy(), level/(float)levels));
		Branch branch_two = new Branch(level, Branch.Right, branch.vertices[2].x, branch.vertices[2].y, rwidth, rwidth, branch.getRotation() - (90-rotation), start.cpy().lerp(end.cpy(), level/(float)levels));
		
		branches.add(branch_one); 
		branches.add(branch_two);
		
		calculateTree(branch_one, level + 1);
		calculateTree(branch_two, level + 1);
	}
	
	//render all branches of the tree
	public void draw(ShapeRenderer renderer){
		for(int i = 0; i < branches.size(); i ++){
			branches.get(i).drawRectangle(renderer);
		}
	}
}
