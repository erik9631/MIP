package assemblies;
import backEnd.Assembly;
import events.TimerEventHandler;
import inventory.InventoryIds;

public class WeaponHandleAssembly extends Assembly
{

	public WeaponHandleAssembly()
	{
		super("Weapon Handle");
		setItemsToTake("METAL", "ALUMINIUM");
		new TimerEventHandler(5000, true, ()-> 
		{
			craft(
					new InventoryIds[]
					{
						InventoryIds.HANDLE
					},
					new int[]
					{
						2
					},
					new InventoryIds[]
					{
						InventoryIds.ALUMINIUM,
						InventoryIds.METAL
					},
					new int[]
					{
						1,
						5,
					}
				);
		}).start();
		new TimerEventHandler(300, true, () ->
		{
			sendOut(
						new InventoryIds[] 
						{
							InventoryIds.HANDLE
						}
					);
		}).start();
	}

}
