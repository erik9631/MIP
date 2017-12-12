package frontEnd;

import backEnd.BaseClass;
import inventory.InventoryIds;

public class InventoryDisplay extends BaseClass
{
	TextLabel[] labels;
	int[] inventory;
	int x, y;
	public InventoryDisplay(int[] inventory, BaseClass referer)
	{
		labels = new TextLabel[InventoryIds.SIZE.ordinal()];
		this.inventory = inventory;
		for(int i = 0; i < labels.length; i++)
		{
			TextLabel label = new TextLabel(referer);
			label.setSize(100, 20);
			labels[i] = label;
		}
	}
	
	
	
	@Override
	protected void Update()
	{
		int assign = 0;
		for(int i = 0; i < InventoryIds.SIZE.ordinal(); i++)
		{
			if(inventory[i] > 0)
			{
				labels[assign].setText(InventoryIds.values()[i] + " " + inventory[i]);
				assign++;
			}
		}
		for(int i = assign; i < InventoryIds.SIZE.ordinal(); i++)
			labels[i].setText(null);
			

	}
	@Override
	protected void Draw()
	{
		for(int i = 0; i < labels.length; i++)
		{
			if(labels[i] != null)
			labels[i].setLocation(x, y + (i * labels[i].getHeight()));
		}
	}
	
	public void setPosition(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}
