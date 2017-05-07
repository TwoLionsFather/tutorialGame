package me.TwoLions.sDodge.GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import me.TwoLions.sDodge.SDodge;
import me.TwoLions.sDodge.GameObject;
import me.TwoLions.sDodge.Handler;
import me.TwoLions.sDodge.ID;

public class BasicEnemy extends GameObject {

	private Handler handler;
	
	public BasicEnemy(float x, float y, ID id, Handler handler) 
	{
		super(5, 16, x, y, id);
		this.handler = handler;
		// TODO Auto-generated constructor stub
		velX = 5;
		velY = 5;
	}

	public void tick() 
	{
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= SDodge.HEIGHT - sizeS) 
			velY *= -1;
		
		if(x <= 0 || x >= SDodge.WIDTH - sizeS) 
			velX *= -1;
		
		
		handler.addObject(new Trail(x, y
									, ID.Trail
									, Color.red
									, sizeS - 2, sizeS - 2 
									, 0.1f
									, handler));
	}

	public void render(Graphics g) 
	{
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect((int) x, (int) y, (int) sizeS, (int) sizeS);
	}

	public Rectangle getBounds() 
	{
		// TODO Auto-generated method stub
		return new Rectangle((int) x, (int) y, (int) sizeS, (int) sizeS);
	}

}
