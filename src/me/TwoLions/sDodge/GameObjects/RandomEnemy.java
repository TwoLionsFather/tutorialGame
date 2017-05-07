package me.TwoLions.sDodge.GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import me.TwoLions.sDodge.SDodge;
import me.TwoLions.sDodge.GameObject;
import me.TwoLions.sDodge.Handler;
import me.TwoLions.sDodge.ID;

public class RandomEnemy extends GameObject {

	private Handler handler;
	private Random r;
	
	public RandomEnemy(float x, float y, ID id, Handler handler) 
	{
		super(-20, 16, x, y, id);
		this.handler = handler;
		// TODO Auto-generated constructor stub
		r = new Random();
		
		velY = r.nextInt(7) + 3;
		velX = r.nextInt(7) + 3;
	}

	public void tick() 
	{
		// TODO Auto-generated method stub
		y += velY;
		x += velX;
				
		if(y <= 0 || y >= SDodge.HEIGHT - (sizeS/2)) 
			velY = ((velY < 0) ? 1 : -1) * (r.nextInt(7) + 3);
				
		if(x <= 0 || x >= SDodge.WIDTH - (sizeS/2)) 
			velX = (velX < 0) ? (r.nextInt(7)+3) : -(r.nextInt(7) + 3);		
			
		if(y <= -sizeS || y >= SDodge.HEIGHT + sizeS)
			handler.removeObject(this);
		if(y <= -sizeS || y >= SDodge.HEIGHT + sizeS)	
			handler.removeObject(this);
			
		handler.addObject(new Trail(x, y
									, ID.Trail
									, Color.yellow
									, sizeS - 2, sizeS - 2
									, 0.1f
									, handler));
	}

	public void render(Graphics g) 
	{
		// TODO Auto-generated method stub
		g.setColor(Color.yellow);
		g.fillRect((int) x, (int) y, (int) sizeS, (int) sizeS);
	}

	public Rectangle getBounds() 
	{
		// TODO Auto-generated method stub
		return new Rectangle((int) x, (int) y, (int) sizeS, (int) sizeS);
	}

}