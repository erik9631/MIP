package assemblies;

import backEnd.Assembly;
import events.TimerEventHandler;
import inventory.InventoryIds;

public class WeaponStockAssembly extends Assembly
{
	public WeaponStockAssembly()
	{
		super("Stock Assembly");
		setItemsToTake("METAL", "ALUMINIUM");
		new TimerEventHandler(1000, true, () ->
		{
			craft(
					new InventoryIds[]
					{
						InventoryIds.STOCK
					}, 
					new int[]
					{
						1
					}, 
					new InventoryIds[]
					{
						InventoryIds.METAL,
						InventoryIds.ALUMINIUM
					},
					new int[]
					{
						5,
						15
					}
				);
		}).start();
		new TimerEventHandler(300, true, () ->
		{
			sendOut(
						new InventoryIds[] 
						{
							InventoryIds.STOCK
						}
					);
		}).start();
	}

}
