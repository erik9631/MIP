package assemblies;

import backEnd.Assembly;
import backEnd.StatTracker;
import events.TimerEventHandler;
import inventory.InventoryIds;

public class WeaponSeller extends Assembly
{
	public WeaponSeller()
	{
		super("Weapon Dealer");
		setItemsToTake("WEAPON");
		new TimerEventHandler(4000, true, () -> 
		{
			sellWeapons();
		}).start();
	}
	
	private void sellWeapons()
	{
		if(getInvCount(InventoryIds.WEAPON) > 0)
		{
			StatTracker.money += 3300;
			removeFrominv(InventoryIds.WEAPON, 1);
		}
	}

}
