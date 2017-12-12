package assemblies;

import backEnd.Assembly;
import events.TimerEventHandler;
import inventory.InventoryIds;

public class WeaponAssembly extends Assembly
{
	public WeaponAssembly()
	{
		super("Weapon Assembly");
		setItemsToTake("METAL", "ALUMINIUM", "BARREL", "HANDLE", "RECIEVER", "STOCK");
		new TimerEventHandler(1000, true, () ->
		{
			craft(
					new InventoryIds[]
					{
						InventoryIds.WEAPON
					}, 
					new int[]
					{
						1
					}, 
					new InventoryIds[]
					{
						InventoryIds.METAL,
						InventoryIds.ALUMINIUM,
						InventoryIds.BARREL,
						InventoryIds.HANDLE,
						InventoryIds.RECIEVER,
						InventoryIds.STOCK
					},
					new int[]
					{
						5,
						10,
						1,
						1,
						1,
						1,
					}
				);
		}).start();
		new TimerEventHandler(300, true, () ->
		{
			sendOut(
						new InventoryIds[] 
						{
							InventoryIds.WEAPON
						}
					);
		}).start();
	}

}
