package me.TwoLions.sDodge;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import me.TwoLions.sDodge.GameObjects.Trail;

public class Player extends GameObject {

	Handler handler;
	HUD hud;
	
	public Player(float x, float y
				, ID id
				, Handler handler
				, HUD hud) 
	{
		super(0, 32, x, y, id);
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() 
	{
		x = x + velX;
		y = y + velY;
		
		x = SDodge.clamp(x, 0, (SDodge.WIDTH - sizeS - 2));
		y = SDodge.clamp(y, 0, (SDodge.HEIGHT - sizeS - 2));
		
		if(velX != 0 || velY != 0)
			handler.addObject(new Trail(x + 1, y + 1
										, ID.Trail
										, Color.white
										, sizeS - 2, sizeS - 2
										, 0.05f
										, handler));
		collision();
	}

	private void collision() 
	{
		// TODO Auto-generated method stub
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					HUD.HEALTH -= tempObject.getDmg();
				}
			}
			
			else if(tempObject.getId() == ID.FastEnemy)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					HUD.HEALTH -= tempObject.getDmg();
				}
			}
			
			else if(tempObject.getId() == ID.Shot)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					HUD.HEALTH -= tempObject.getDmg();
				}
			}
			
			else if(tempObject.getId() == ID.RandomEnemy)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					hud.setScore((hud.getscore() + 600)); 
					HUD.HEALTH -= tempObject.getDmg();
					handler.removeObject(tempObject);
				}
			}
			
			else if(tempObject.getId() == ID.BasicHealthPack)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					HUD.HEALTH = 100;
					handler.removeObject(tempObject);
				}
			}			
		}
	}

	public void render(Graphics g) 
	{		
		g.setColor(Color.white);		
		g.fillRect((int) x, (int) y, (int) sizeS, (int) sizeS);
	}

	public Rectangle getBounds() 
	{
		// TODO Auto-generated method stub
		return new Rectangle((int) x, (int) y, (int) sizeS, (int) sizeS);
	}

	
	
}
