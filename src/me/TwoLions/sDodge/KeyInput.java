package me.TwoLions.sDodge;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter 
{

	private Handler handler;
	private boolean[] keyDown = new boolean [] {false, false, false, false};
	private int speedP1 = 5;
		
	public KeyInput(Handler handler)
	{
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		if(handler.player.getId() == ID.Player)
		{
			if(key == KeyEvent.VK_W)
			{
				handler.player.setVelY(- speedP1); 
				keyDown[0] = true;
			}
						
			if(key == KeyEvent.VK_S)
			{
				handler.player.setVelY(speedP1);
				keyDown[1] = true;
			}
						  
			if(key == KeyEvent.VK_A)
			{
				handler.player.setVelX(- speedP1);
				keyDown[2] = true;
			}
			
			if(key == KeyEvent.VK_D)
			{
				handler.player.setVelX(speedP1);
				keyDown[3] = true;
			}
		}
		
//		for(int i = 0; i < handler.object.size(); i++){
//			GameObject tempObject = handler.object.get(i);
//			
//		}
			
		if(key == KeyEvent.VK_ESCAPE) 
			System.exit(0);
		
	}
	
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		if(handler.player.getId() == ID.Player)
		{
			if(key == KeyEvent.VK_W)
			{
				keyDown[0] = false;
				if(keyDown[1]) 
					handler.player.setVelY(speedP1); 
			}
			
			if(key == KeyEvent.VK_S)
			{
				keyDown[1] = false;
				if(keyDown[0]) 
					handler.player.setVelY(- speedP1); 
			}
			
			if(key == KeyEvent.VK_A)
			{
				keyDown[2] = false;
				if(keyDown[3]) 
					handler.player.setVelX(speedP1); 
			}
			
			if(key == KeyEvent.VK_D)
			{
				keyDown[3] = false;
				if(keyDown[2]) 
					handler.player.setVelX(- speedP1); 
			}
			
			if(!keyDown[0] && !keyDown[1])
				handler.player.setVelY(0);					
			
			if(!keyDown[2] && !keyDown[3])
				handler.player.setVelX(0);					
		}
			
		
//		for(int i = 0; i < handler.object.size(); i++){
//			GameObject tempObject = handler.object.get(i);			
//			
//		}
	
	}
}
