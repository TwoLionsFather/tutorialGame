package me.TwoLions.sDodge;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

	
	public static float HEALTH = 100;
	private float greenVal = 0xFF;
	
	private int score = 0;
	private int level = 1;
	
	public void tick()
	{
		HEALTH = SDodge.clamp(HEALTH
							, 0, 100);
		greenVal = SDodge.clamp(greenVal
								, 0, 255);
		
		greenVal = HEALTH*2;
		score++;
	}
	
	public void render(Graphics g)
	{
		//Healthbar
		g.setColor(Color.gray);
		g.fillRect(15, 15
				, 200, 32);
		
		g.setColor(Color.white);
		g.drawRect(15, 15
				, 198, 30);
		
		g.setColor(new Color((255 - (int) greenVal), ((int) greenVal), 0));
		g.fillRect(15, 15
				, (int) HEALTH * 2
				, 32);	
		
		//Score etc.
		g.setColor(Color.white);
		g.drawString("Score: " + score
					, 16, 64);
		g.drawString("Level: " + level
					, 16, 80);
	}
	
	public void setScore(int score)
	{
		this.score = score;
	}
	
	public int getscore()
	{
		return score;
	}
	
	public void setLevel(int level)
	{
		this.level = level;
	}
	
	public int getLevel()
	{
		return level;
	}
}
