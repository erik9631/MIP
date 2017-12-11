package backEnd;

import frontEnd.TextLabel;

public class StatTracker extends BaseClass
{
	public static double money;
	public static StatTracker tracker;
	TextLabel label;
	@Override
	protected void Draw()
	{
		label.setText("Money: " + money);
		// TODO Auto-generated method stub
	}
	
	public StatTracker()
	{
		super();
		tracker = this;
		money = 20000;
		label = new TextLabel(this);
		label.setLocation(getMainFrame().getWidth() - 150, 0);
		label.setText("Money: " + money);
	}
}
