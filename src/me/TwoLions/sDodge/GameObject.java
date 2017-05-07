package me.TwoLions.sDodge;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected float sizeS;
	protected float x, y;
	protected float velX, velY;
	protected float dmg;
	protected ID id;	
	
	public GameObject(float dmg
					, float size
					, float x, float y
					, ID id)
	{
		this.dmg = dmg;
		this.sizeS = size;
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	
	public void setX(float x)
	{
		this.x = x;
	}
	
	public void setY(float y)
	{
		this.y = y;
	}
	
	public float getX()
	{
		return x;
	}	
	
	public float getY()
	{
		return y;
	}
	
	public void setId(ID id)
	{
		this.id = id;
	}
	
	public ID getId()
	{
		return id;
	}
	
	public void setVelX(float velX)
	{
		this.velX = velX;
	}
	
	public void setVelY(float velY)
	{
		this.velY = velY;
	}
	
	public float getVelX()
	{
		return velX;
	}
	
	public float getVelY()
	{
		return velY;
	}
	
	public void setDmg(float dmg)
	{
		this.dmg = dmg;
	}
	
	public float getDmg()
	{
		return this.dmg;
	}
	
}
