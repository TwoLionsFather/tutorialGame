package me.TwoLions.sDodge.GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import me.TwoLions.sDodge.SDodge;
import me.TwoLions.sDodge.GameObject;
import me.TwoLions.sDodge.Handler;
import me.TwoLions.sDodge.ID;

public class FastEnemyS extends GameObject {

	private Handler handler;
	
	public FastEnemyS(float x, float y, ID id, Handler handler) 
	{
		super(10, 16, x, y, id);
		
		this.handler = handler;
		// TODO Auto-generated constructor stub
		velX = 8;
		velY = 8;
	}

	public void tick() 
	{
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= SDodge.HEIGHT - (sizeS/2)) 
			velY *= -1;
		if(x <= 0 || x >= SDodge.WIDTH - (sizeS/2)) 
			velX *= -1;
		
		
		handler.addObject(new Trail(x, y
									, ID.Trail
									, Color.blue
									, sizeS - 2, sizeS - 2
									, 0.1f
									, handler));
	}

	public void render(Graphics g) 
	{
		// TODO Auto-generated method stub
		g.setColor(Color.blue);
		g.fillRect((int) x, (int) y, (int) sizeS, (int) sizeS);
	}

	public Rectangle getBounds() 
	{
		// TODO Auto-generated method stub
		return new Rectangle((int) x, (int) y, (int) sizeS, (int) sizeS);
	}

}