package me.TwoLions.sDodge;

import java.util.Random;

import me.TwoLions.sDodge.GameObjects.BasicEnemy;
import me.TwoLions.sDodge.GameObjects.BasicHealthPack;
import me.TwoLions.sDodge.GameObjects.FastEnemy;
import me.TwoLions.sDodge.GameObjects.FastEnemyS;
import me.TwoLions.sDodge.GameObjects.RandomEnemy;
import me.TwoLions.sDodge.GameObjects.verticalShot;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	private int scoreKeep = 0;
	private int scoreLim = 100;
	
	public Spawn(Handler handler, HUD hud)
	{
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick()
	{
		scoreKeep++;
		if(levelCheck(hud.getLevel(), scoreKeep, scoreLim))
		{
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			//Bedenke Ruckel von Gegner Spawn
			if(hud.getLevel() < 5)
			{				
				handler.addObject(new RandomEnemy(r.nextInt((int) SDodge.WIDTH - 16)
												, r.nextInt((int) SDodge.HEIGHT - 16)
												, ID.RandomEnemy
												, handler));
				
				for(int i = 0; i < 3; i++)
				{
					handler.addObject(new BasicEnemy( r.nextInt((int) SDodge.WIDTH - 16)
													, r.nextInt((int) SDodge.HEIGHT - 16)
													, ID.BasicEnemy
													, handler));					
				}
			}
			
			else if(hud.getLevel() < 15)
			{
				handler.addObject(new BasicEnemy( r.nextInt((int) SDodge.WIDTH - 16)
												, r.nextInt((int) SDodge.HEIGHT - 16)
												, ID.BasicEnemy
												, handler));
				
				handler.addObject(new FastEnemy(0, 0
												, ID.FastEnemy
												, handler));
			}
			
			else if(hud.getLevel() == 20)
			{
				handler.removeAll();
				handler.addObject(new FastEnemy(0 , 0
												, ID.FastEnemy
												, handler));
			}
			
			else if(hud.getLevel() < 30)
			{
				scoreLim = 120;
				for(int i = 0; i < 2; i++)
				{
					if(r.nextBoolean()) 
						handler.addObject(new FastEnemy(0 , 0
														, ID.FastEnemy
														, handler));
					
					else 
						handler.addObject(new FastEnemy(((int) SDodge.WIDTH - 16)
														, ((int) SDodge.HEIGHT - 16)
														, ID.FastEnemy
														, handler));
				}
				
			}
			
			else if(hud.getLevel() < 35)
			{
				if(hud.getLevel() == 30)
					handler.removeAll();
				
				for(int i = 0; i < SDodge.HEIGHT - 16; i += 100)
				{
					handler.addObject(new FastEnemyS(0, i
													, ID.BasicEnemy
													, handler));
				}
				scoreLim = 150;
			}
			else if(hud.getLevel() < 40)
			{
				//kluge Formel für schwierigkeitsgrad erhöhung mit steigendem Level :/
				for(float i = 40; i < SDodge.HEIGHT; i += 150)
				{
					handler.addObject(new verticalShot(	30
														, 0, SDodge.clamp(i, 0, (SDodge.HEIGHT + 10))
														, ID.Shot
														, handler));
				}
			}
			
			if( hud.getLevel() > 20 && ((hud.getLevel() - 25) % 5 == 0))
			{
				handler.addObject(new BasicHealthPack(r.nextInt((int) SDodge.WIDTH - 16)
													, r.nextInt((int) SDodge.HEIGHT - 16)
													, ID.BasicHealthPack));
			}
		}		
	}
	
	private boolean levelCheck(int levelCur, int scoreCur, int scoreLim)
	{
		if(scoreLim - scoreCur > 0)
			return false;
		
		return true;
	}
}
