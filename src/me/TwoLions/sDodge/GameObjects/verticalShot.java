package me.TwoLions.sDodge.GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import me.TwoLions.sDodge.SDodge;
import me.TwoLions.sDodge.GameObject;
import me.TwoLions.sDodge.Handler;
import me.TwoLions.sDodge.ID;

public class verticalShot extends GameObject {

	private Handler handler;

	public verticalShot(float dmg, float x, float y, ID id, Handler handler)
	{
		super(dmg, 10, x, y, id);
		
		this.dmg = dmg;
		this.handler = handler;
		// TODO Auto-generated constructor stub
		velX = 20;
		velY = 0;
	}
	
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		
		if(x > SDodge.WIDTH)
			handler.removeObject(this);
		
		if(y > SDodge.HEIGHT)
			handler.removeObject(this);
		
		handler.addObject(new Trail(x - 1, y - 1
									, ID.Trail
									, Color.red
									, sizeS - 2, sizeS - 2 
									, 0.15f
									, handler));
	}

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(new Color(125, 125, 0));
		g.fillRect((int) x, (int) y, (int) sizeS, (int) sizeS);
	}

	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int) x, (int) y, (int) sizeS, (int) sizeS);
	}

}
