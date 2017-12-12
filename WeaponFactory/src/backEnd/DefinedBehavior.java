package backEnd;

import java.util.ArrayList;

import frontEnd.MainFrame;

public abstract class DefinedBehavior
{
	protected ArrayList<String> tags;
	
	protected static ApplicationController controller;
	protected static MainFrame mainFrame;
	protected static SideBar siderBar;
	public static AppCursor appCursor;
	
	abstract void Update();
	abstract void Draw();
	
	abstract protected void addTag(String tag);
	abstract public boolean containsTag(String tag);
	
	DefinedBehavior()
	{
		controller.addToscene(this);
	}
	public static void setController(ApplicationController control)
	{
		controller = control;
	}
	public static void setMainGui(MainFrame frame)
	{
		mainFrame = frame;
	}
	public static MainFrame getMainFrame()
	{
		return mainFrame;
	}
	public static ApplicationController getController()
	{
		return controller;
	}
	public static SideBar getSideBar()
	{
		return siderBar;
	}
}
