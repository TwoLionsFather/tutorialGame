package me.TwoLions.sDodge.GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import me.TwoLions.sDodge.GameObject;
import me.TwoLions.sDodge.ID;

public class BasicHealthPack extends GameObject {
	
	public BasicHealthPack(float x, float y, ID id) 
	{
		super(0, 20, x, y, id);
		// TODO Auto-generated constructor stub
	}


	public void tick() 
	{
		// TODO Auto-generated method stub
	}


	public void render(Graphics g) 
	{
		// TODO Auto-generated method stub		
		g.setColor(Color.cyan);
		g.fillRect((int) x, (int) y, (int) sizeS, (int) sizeS);
	}


	public Rectangle getBounds() 
	{
		// TODO Auto-generated method stub
		return new Rectangle((int) x, (int) y, (int) sizeS, (int) sizeS);
	}
	
}
