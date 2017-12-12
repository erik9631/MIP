package events;

import java.util.ArrayList;

import events.event.LoadLayerEvent;

public class LoadLayerEventHandler
{
	private static boolean mainLoaded = true;
	static ArrayList<LoadLayerEvent> subscribers = new ArrayList<LoadLayerEvent>();
	
	public static boolean mainIsLoaded()
	{
		return mainLoaded;
	}
	
	public static void subscribe(LoadLayerEvent subscriber)
	{
		subscribers.add(subscriber);
	}
	
	public static void unsubscribe(LoadLayerEvent subscriber)
	{
		if(subscribers.contains(subscriber))
			subscribers.remove(subscriber);
	}
	
	public static void LoadLayer(int layer)
	{
		for(LoadLayerEvent i : subscribers)
		{
			if(i.getLayer() == layer)
				i.actionLoadLayer();
			else
				i.actionUnloadLayer();
		}
	}
	
	/*private static void UnloadMain(int layer)
	{
		for(LoadMainEvent i : subscribers)
		{
			i.actionUnloadLayer();
		}
		mainLoaded = false;
	}*/
}
