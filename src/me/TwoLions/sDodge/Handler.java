package me.TwoLions.sDodge;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	GameObject player;
	
	public void tick()
	{
		for(int i = 0; i < object.size(); i++)
		{
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
		player.tick();
	}
	
	public void render(Graphics g)
	{
		for(int i = 0; i < object.size(); i++)
		{
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
		player.render(g);
	}
	
	public void addObject(GameObject object)
	{
		this.object.add(object);
	}
	
	public void addPlayer(GameObject playerObject)
	{
		this.player = playerObject;
	}
	
	public void removeObject(GameObject object)
	{
		this.object.remove(object);
	}
	
	public void removeType(ID removeType)
	{
		for(int i = 0; i < object.size(); i++)
		{
			if(object.get(i).getId() == removeType)
			{
				object.remove(i);
			}
		}		
	}
	
	public void removeAll()
	{
		this.object.clear();
	}
}
