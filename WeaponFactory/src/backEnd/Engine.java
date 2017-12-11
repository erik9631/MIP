package backEnd;
import continents.*;
import events.LoadLayerEventHandler;

public class Engine
{
	public static void init()
	{
		LoadLayerEventHandler.LoadLayer(0);
		new AppCursor();
		new StatTracker();
		new Africa();
		new America();
		new Europe();
		new Asia();
		new SideBar();
	}
}
