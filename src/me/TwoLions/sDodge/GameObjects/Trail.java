package me.TwoLions.sDodge.GameObjects;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import me.TwoLions.sDodge.GameObject;
import me.TwoLions.sDodge.Handler;
import me.TwoLions.sDodge.ID;

public class Trail extends GameObject {

	private float width, height;
	private float life;		//life = 0.001 - 0.1
	private float alpha = 1;
	private Handler handler;
	private Color color;
	
	public Trail(float x, float y
				, ID id
				, Color color
				, float width, float height
				, float life
				, Handler handler) 
	{
		//-1 da nicht quadratisch!
		super(0, -1, x, y, id);
		// TODO Auto-generated constructor stub
		this.handler = handler;
		this.color = color;
		this.width = width;
		this.height = height;
		this.life = life;
	}


	public void tick()
	{
		// TODO Auto-generated method stub
		if (alpha > life)
			alpha -= life - 0.01f;
		
		else handler.removeObject(this);
		
	}


	public void render(Graphics g) 
	{
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		g2d.setColor(color);
		g.fillRect((int) x, (int) y, (int) width, (int) height);
		
		g2d.setComposite(makeTransparent(1));
	}


	private AlphaComposite makeTransparent(float alpha)
	{
		int type = AlphaComposite.SRC_OVER;		
		return (AlphaComposite.getInstance(type, alpha));
	}
	
	public Rectangle getBounds() 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
