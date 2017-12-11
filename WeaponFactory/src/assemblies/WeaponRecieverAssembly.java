package assemblies;

import backEnd.Assembly;
import events.TimerEventHandler;
import inventory.InventoryIds;

public class WeaponRecieverAssembly extends Assembly
{
	public WeaponRecieverAssembly()
	{
		super("Reciever Assembly");
		setItemsToTake("METAL", "ALUMINIUM");
		new TimerEventHandler(3000, true, () ->
		{
			craft(
					new InventoryIds[]
					{
						InventoryIds.RECIEVER
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
						10,
						10
					}
				);
		}).start();
		new TimerEventHandler(300, true, () ->
		{
			sendOut(
						new InventoryIds[] 
						{
							InventoryIds.RECIEVER
						}
					);
		}).start();
	}

}
