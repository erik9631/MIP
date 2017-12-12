package backEnd;

import java.util.ArrayList;

import frontEnd.MainFrame;

public class ApplicationController
{
	// Init
	ArrayList<DefinedBehavior> scene;
	ArrayList<DefinedBehavior> updatePool;
	private long currentTime;
	private long deltaTime;
	private int fps;
	private long ticks;
	
	//FrameRate calculation
	private long oldFrameTime;
	private long deltaBetweenFrame;
	
	//Graphics Controller
	//private boolean continentGraphicsEnabled;
	
	ApplicationController(MainFrame mainFrame)
	{
		//continentGraphicsEnabled = true;
		scene = new ArrayList<DefinedBehavior>();
		updatePool = new ArrayList<DefinedBehavior>();
		DefinedBehavior.setController(this);
		DefinedBehavior.mainFrame = mainFrame;
		
		currentTime = System.currentTimeMillis();
		oldFrameTime = System.currentTimeMillis();
		deltaTime = System.currentTimeMillis();
		fps = 60;
	}
	
	public void addToscene(DefinedBehavior obj)
	{
		updatePool.add(obj);
	}
	
	public DefinedBehavior findByTag(String tag)
	{
		for(int i = 0; i < scene.size(); i++)
		{
			if(scene.get(i).containsTag(tag))
				return scene.get(i);
		}
		return null;
	}
	
	void onUpdate()
	{
		
		for(int i = 0; i < scene.size(); i++)
		{
			scene.get(i).Update();
			scene.get(i).Draw();
		}
		scene.addAll(updatePool);
		updatePool.clear();
		//DefinedBehavior.getMainFrame().setTitle("FPS: " + Integer.toString(getFrameRate()));
		
	}
	
	public long getTicks()
	{
		return ticks;
	}
	
	public int getTimeDelta()
	{
		deltaBetweenFrame = currentTime - oldFrameTime;
		return (int)deltaBetweenFrame;
	}
	
	public int getFrameRate()
	{
		int frameRate = (int)(1000 / getTimeDelta());
		return frameRate;
	}
	
	void Update()
	{
		currentTime = System.currentTimeMillis();
		if(deltaTime <= currentTime)
		{
			onUpdate();
			deltaTime = (1000/fps) + currentTime;
			oldFrameTime = System.currentTimeMillis();
		}
	}
	
}