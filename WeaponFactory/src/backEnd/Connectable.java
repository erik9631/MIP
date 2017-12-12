package backEnd;

import java.awt.Color;
import java.util.ArrayList;

import inventory.InventoryIds;

public interface Connectable
{
	public void addToInv(InventoryIds id, int count);
	public void setColor(int r, int g, int b);
	public void setColor(Color c);
	public boolean containsTag(String tag);
	public ArrayList<Connectable> getLinks();

}
