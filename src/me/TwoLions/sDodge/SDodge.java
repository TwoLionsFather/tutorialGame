package me.TwoLions.sDodge;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import me.TwoLions.sDodge.GameObjects.BasicEnemy;

public class SDodge extends Canvas implements Runnable {

	//InvalidClassException falls anderes Java... http://stackoverflow.com/questions/285793/what-is-a-serialversionuid-and-why-should-i-use-it
	private static final long serialVersionUID = 7424844572637599276L;

	public static final String TITLE = "SDODGE";
	public static final float WIDTH = 1920; //1920 für Fullscreen
	public static final float HEIGHT = WIDTH / 16 * 9;
	
	public STATE gameState = STATE.Game;
	
	public static double dfficulty = 1.0; //1.0 = normal
	
	private boolean running = false;
	private Thread thread;	
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	
	public enum STATE
	{
		Menu(),
		Game();
	}
	
	public SDodge()
	{		
		handler = new Handler();
		hud = new HUD();
		spawner = new Spawn(handler, hud);
		
		this.addKeyListener(new KeyInput(handler));	
		
		new Window(WIDTH, HEIGHT
						, TITLE
						, this);
		
		if(gameState == STATE.Game)
		{
			handler.addPlayer(new Player(WIDTH/2, HEIGHT/2
										, ID.Player
										, handler
										, hud));

			handler.addObject(new BasicEnemy(0, 0
											, ID.BasicEnemy
											, handler));
		}
		
	}
	
	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop()
	{
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}			
	}
	
	public void run()
	{
		this.requestFocus();
		
		double target = 60.0 * dfficulty; 		//FPS Frames per secound	
		double nsPerTick = 1000000000 / target;
		double unprocessed = 0.0;
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		int fps = 0;
		int tps = 0;
		boolean canRender = false;
		
		while(running)
		{
			long now = System.nanoTime();
			unprocessed += (now - lastTime) / nsPerTick;
			lastTime = now;
			
			if(unprocessed >= 1.0)
			{
				tick();
				unprocessed--;
				tps++;
				canRender = true;
			}
			else
				canRender = false;
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(canRender) 
			{
				fps++;
				render();
			}
			
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				System.out.printf("FPS: %d | TPS: %d\n", fps, tps);
				fps = 0;
				tps = 0;
			}
		}
		stop();		
	}
	
	private void tick()
	{
		if(gameState == STATE.Game)
		{
			handler.tick();
			hud.tick();
			spawner.tick();
		}
		
	}
	
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3); // 2 - 4 Ruckel > Performance
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, (int) WIDTH, (int) HEIGHT);
		
		
		if(gameState == STATE.Game)
		{
			hud.render(g);
			handler.render(g);	
		}
		else{
			g.setColor(Color.WHITE);
			g.drawString("Menu", 100, 100);
		}

		g.dispose();
		bs.show();
	}
	
	public static void main(String args[])
	{ 
		new SDodge();
	}

	public static float clamp(float var, float min, float max)
	{
		if(var >= max)
			return var = max;
		
		else if(var <= min)
			return var = min;
		
		else 
			return var;
	}
}
