package backEnd;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import backEnd.shopMenu.Holdable;
import events.event.LoadLayerEvent;
import frontEnd.AppButton;
import frontEnd.InventoryDisplay;
import inventory.InventoryIds;

public class Assembly extends BaseClass implements Clickable, LoadLayerEvent, Holdable, Connectable
{
	
	
	String name;
	ArrayList<Worker> workers;
	double effeciency;
	double energyCost;
	double maintenanceCost;
	double productionSpeed;
	double buyCost;
	private int wantedSize = 17;
	private int wantedLenght = 10;
	protected Company company;
	//Inventory inventory;
	int[] inv;
	InventoryIds[] acceptableItems;	
	//Gui
	int layer = 1;
	AppButton button;
	int width, height;
	int x, y;
	Font font;
	InventoryDisplay invDisplay;
	
	ArrayList<Connectable> links;
	protected Assembly(String name)
	{
		width = 100;
		this.name = name;
		height = 50;
		button = new AppButton(width, height, name, this);
		System.out.println("Button inited");
		inv = new int[InventoryIds.SIZE.ordinal()];
		links = new ArrayList<Connectable>();		
		invDisplay = new InventoryDisplay(inv, this);
		font = new Font("Arial", 0, (int) (wantedLenght*wantedSize / (name.length())) );
		button.setFont(font);

	}
	
	protected void setItemsToTake(String ...items)
	{
		for(String i : items)
		{
			addTag(i);
		}
	}
	
	public double getBuyCost()
	{
		return buyCost;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setGraphicsEnabled(boolean enabled)
	{
		button.setEnabled(enabled);
		button.setVisible(enabled);
	}
	
	public void addWorker(Worker worker)
	{
		workers.add(worker);
	}
	
	/*public ArrayLists<Worker> getWorkers()
	{
		
	}*/
	
	/*Worker getWorker(int i)
	{
		return workers.get(i);
	}*/
	
	public double getEnergyCost()
	{
		return energyCost;
	}
	
	public double getMaintenanceCost()
	{
		return maintenanceCost;
	}
	
	public double getProductionSpeed()
	{
		return productionSpeed;
	}

	@Override
	public void onClick()
	{
		if(appCursor.getHoldable() != null)
			if(appCursor.getHoldable().equals(this))
			{
				appCursor.clearHoldable();
				return;
			}
		appCursor.setHoldable(this);
	}
	
	@Override
	protected void Update()
	{
		
	}

	@Override
	protected void Draw()
	{
		//System.out.println(button);
		if(button != null)
			button.setLocation(x, y);
		if(invDisplay != null)
			invDisplay.setPosition(x, y + button.getHeight());
	}
	
	@Override
	public void actionLoadLayer()
	{
		setGraphicsEnabled(true);
	}

	@Override
	public int getLayer()
	{
		return layer;
	}

	@Override
	public void actionUnloadLayer()
	{
		setGraphicsEnabled(false);
	}

	@Override
	public void MoveHeld(int x, int y)
	{
		this.x = x - width/2;
		this.y = y - height/2;
	}
	
	public void addToInv(InventoryIds id, int count)
	{
		inv[id.ordinal()] += count;
	}
	
	public void removeFrominv(InventoryIds id, int count)
	{
		inv[id.ordinal()] -= count;
	}
	
	public int getInvCount(InventoryIds id)
	{
		return inv[id.ordinal()];
	}
	
	public void setColor(Color c)
	{
		button.setBackground(c);
	}
	
	@Override
	public void setColor(int r, int g, int b)
	{
		Color c = new Color(r, g, b);
		button.setBackground(c);
	}
	
	
	private void setConnection()
	{
		if(appCursor.getConnectable() == null)
		{
			appCursor.setConnectable(this);
			setColor(19, 138, 198);
		}
		else
		{
			if(appCursor.getConnectable() == this)
				return;
			if(appCursor.getConnectable().getLinks().contains(this))
			{
				System.out.println("ALREADY CONNECTED");
				return;
			}
			//links.add(appCursor.getConnectable());
			appCursor.getConnectable().getLinks().add(this);
			appCursor.clearHoldable();
			setColor(null);
			appCursor.getConnectable().setColor(null);
			appCursor.clearConnectable();
		}
	}

	@Override
	public void onRightClick()
	{
		setConnection();
	}
	
	protected void sendOut(InventoryIds[] items) //Specify the items to send out.
	{
		for(int i = 0; i < links.size(); i++)
		{
			for(int j = 0; j < items.length; j++)
			{
				if(links.get(i).containsTag(items[j].toString()) == false)
					break;
				if(getInvCount(items[j]) < 1)
					return;
				links.get(i).addToInv(items[j], 1);
				removeFrominv(items[j], 1);
				//System.out.println("Added " + items[j].toString() + " to: " + links.get(i) + " And decreased from " + this + " to " + inv[items[j].ordinal()]);
			}
		}
	}

	@Override
	public void onHover()
	{
		Connectable currentInput = appCursor.getConnectable();
		if(currentInput != this && currentInput != null)
		{
			setColor(60, 220, 97);
		}
	}

	@Override
	public void onMouseExit()
	{
		Connectable currentInput = appCursor.getConnectable();
		if(currentInput != this && currentInput != null)
		{
			setColor(null);
		}
	}
	
	protected void craft(InventoryIds[] items, int[] numberToCreate ,InventoryIds[] recipes, int[] resourcesNeeded) // You specify the items you want to craft
	{																				// And the recipe required with the amount of items for each recipe
		//Check if inventory contains enough items
		for(int i = 0; i < recipes.length; i++)
		{
			if(getInvCount(recipes[i]) < resourcesNeeded[i])
			{
				//System.out.println("Item " + recipes[i] + " lacking. Can not craft");
				return;
			}
		}
		//If it does, take the items
		for(int i = 0; i < recipes.length; i++)
			removeFrominv(recipes[i], resourcesNeeded[i]);
		
		//Create new ones
		for(int i = 0; i < items.length; i++)
		{
			//System.out.println("Crafted " + items[i]);
			addToInv(items[i], numberToCreate[i]);
		}
	}
	
	public void setCompany(Company company)
	{
		this.company = company;
	}

	@Override
	public ArrayList<Connectable> getLinks()
	{
		return links;
	}
	
	/*public Inventory()
	{
		return inventory;
	}*/
	
}
