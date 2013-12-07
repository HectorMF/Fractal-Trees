package com.perfectplay.org;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

/* 
 * Trees are a collection of branches. Given a trunk, trees can be generated 
 * recursively.
 * Written By: Hector Medina-Fetterman
 * Date: 12/7/2013
 */
public class Tree {
	//a list of all branches in the tree
	private ArrayList<Branch> branches;
	
	private int levels;
	private int rotation;

	private Color start;
	private Color end;
	
	public Tree(int levels, int rotation, int start_width, int start_height, Color start, Color end){
		branches = new ArrayList<Branch>();
		//create the trunk
		Branch trunk = new Branch(Gdx.graphics.getWidth()/2, 0, start_width, start_height, 0, start);
		branches.add(trunk);
		this.start = start;
		this.end = end;
		this.levels = levels;
		this.rotation = rotation;
		calculateTree(trunk,0);
	}
	
	//recursive function used to calculate each iteration
	private void calculateTree(Branch branch, int level){
		if(level >= levels) return;
		
		Vector2 center = branch.getCenterPosition();
		int width = (int) (branch.getWidth()/(float)Math.sqrt(2)+.5);
		int height = (int) (branch.getHeight()/(float)Math.sqrt(2)+.5);

		Branch branch_one = new Branch(center.x, center.y, width, height, branch.getRotation() + rotation/2, start.cpy().lerp(end.cpy(), level/(float)levels));
		Branch branch_two = new Branch(center.x, center.y, width, height, branch.getRotation() - rotation/2, start.cpy().lerp(end.cpy(), level/(float)levels));
		
		branches.add(branch_one); 
		branches.add(branch_two);
		
		calculateTree(branch_one, level + 1);
		calculateTree(branch_two, level + 1);
	}
	
	//render all branches of the tree
	public void draw(ShapeRenderer renderer){
		for(int i = 0; i < branches.size(); i ++){
			branches.get(i).draw(renderer);
		}
	}
}
