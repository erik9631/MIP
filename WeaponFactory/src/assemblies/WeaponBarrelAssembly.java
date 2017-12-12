package assemblies;

import backEnd.Assembly;
import events.TimerEventHandler;
import inventory.InventoryIds;

public class WeaponBarrelAssembly extends Assembly
{
	public WeaponBarrelAssembly()
	{
		super("Barrel Assembly");
		setItemsToTake("METAL", "ALUMINIUM");
		/* TODO
		 * 
		 * Remove argument, make local variables specifying the argument
		 * 
		 */
		new TimerEventHandler(2000, true, () ->
		{
			craft(
					new InventoryIds[]
					{
						InventoryIds.BARREL
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
						20,
						10
					}
				);
		}).start();
		new TimerEventHandler(300, true, () ->
		{
			sendOut(
						new InventoryIds[] 
						{
							InventoryIds.BARREL
						}
					);
		}).start();
	}

}
