package me.TwoLions.sDodge.GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import me.TwoLions.sDodge.SDodge;
import me.TwoLions.sDodge.GameObject;
import me.TwoLions.sDodge.Handler;
import me.TwoLions.sDodge.ID;

public class FastEnemy extends GameObject {

	private Handler handler;
	private Random r;
	
	public FastEnemy(float x, float y, ID id, Handler handler) 
	{
		super(10, 16, x, y, id);
		
		this.handler = handler;
		// TODO Auto-generated constructor stub
		r = new Random();
		velX = r.nextInt(7)+6;
		velY = r.nextInt(7)+6;
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