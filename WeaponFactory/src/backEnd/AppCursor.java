package backEnd;

import backEnd.shopMenu.Holdable;


public class AppCursor extends BaseClass
{
	int x;
	int y;
	boolean holding;
	private Holdable holdable;
	private Connectable input;
	AppCursor()
	{
		DefinedBehavior.appCursor = this;
	}
	
	Holdable getHoldable()
	{
		return holdable;
	}
	
	public void clearConnectable()
	{
		input = null;
	}
	
	public void setHoldable(Holdable holdable)
	{
		this.holdable = holdable;
	}
	
	public void setConnectable(Connectable input)
	{
		this.input = input;
	}
	
	public Connectable getConnectable()
	{
		return input;
	}
	
	public void clearHoldable()
	{
		this.holdable = null;
	}
	
	private void updateHeld()
	{
		if(holdable != null)
			holdable.MoveHeld(x, y);
	}
	
	private void updateMousePosition()
	{
		if(DefinedBehavior.getMainFrame().getPanel().getMousePosition() != null)
		{
			try
			{
				x = DefinedBehavior.getMainFrame().getPanel().getMousePosition().x;
				y = DefinedBehavior.getMainFrame().getPanel().getMousePosition().y;
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage() + " at: " + this.getClass());
			}
		}	
	}
	
	@Override
	protected void Update()
	{
		updateMousePosition();
		updateHeld();
	}
}