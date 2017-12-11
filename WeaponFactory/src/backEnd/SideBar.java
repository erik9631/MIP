package backEnd;

import BuyActions.BuyMaterialProcessing;
import BuyActions.BuyWeaponAssembly;
import BuyActions.BuyWeaponBarrelAssembly;
import BuyActions.BuyWeaponDealer;
import BuyActions.BuyWeaponHandleAssembly;
import BuyActions.BuyWeaponRecieverAssembly;
import BuyActions.BuyWeaponStockAssembly;
import assemblies.WeaponSeller;
import backEnd.shopMenu.BuyButton;
import events.LoadLayerEventHandler;
import events.event.LoadLayerEvent;
import frontEnd.ButtonPanel;

public class SideBar extends BaseClass implements LoadLayerEvent
{
	ButtonPanel panel;
	int x, y;
	int width, height;
	int layer;
	public SideBar()
	{
		super();
		panel = new ButtonPanel();
		DefinedBehavior.siderBar = this;
		LoadLayerEventHandler.subscribe(this);
		layer = 1;
		
		width = 250;
		height = 800;
		x = DefinedBehavior.getMainFrame().getWidth() - width;
		y = 0;
		
		panel.setEnabled(false);
		panel.setVisible(false);
		
		//Space size - 10
		
		new BuyButton(100, 50, 0, 50, "Material\nSmelter", new BuyMaterialProcessing());
		new BuyButton(100, 50, 110, 50, "Weapon\nHandle Assembly", new BuyWeaponHandleAssembly());
		new BuyButton(100, 50, 0, 110, "Weapon\nReciever Assembly", new BuyWeaponRecieverAssembly());
		new BuyButton(100, 50, 110, 110, "Weapon\nBarrel Assembly", new BuyWeaponBarrelAssembly());
		new BuyButton(100, 50, 0, 170, "Weapon\nStock Assembly", new BuyWeaponStockAssembly());
		new BuyButton(100, 50, 110, 170, "Weapon\nAssembly", new BuyWeaponAssembly());
		new BuyButton(100, 50, 0, 230, "Weapon\nDealer", new BuyWeaponDealer());
		// Button Panel is going to contain all the buttons for creating assemblies
	}
	
	public ButtonPanel getPanel()
	{
		return panel;
	}
	
	public void setGraphicsEnabled(boolean enabled)
	{
		panel.setEnabled(enabled);
		panel.setVisible(enabled);
	}
	
	@Override
	protected void Draw()
	{
		panel.setLocation(x, y);
		panel.setSize(250, 600);
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
	
}
