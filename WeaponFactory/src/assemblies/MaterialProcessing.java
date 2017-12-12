package assemblies;
import backEnd.Assembly;
import backEnd.StatTracker;
import events.TimerEventHandler;
import inventory.InventoryIds;

public class MaterialProcessing extends Assembly
{
	public MaterialProcessing()
	{
		super("Material Processing");
		new TimerEventHandler(2000, true, () -> 
		{
			processMaterials();
		}).start();
		
		new TimerEventHandler(300, true, () ->
		{
			sendOut(
						new InventoryIds[] 
						{
							InventoryIds.METAL,
							InventoryIds.ALUMINIUM,
							InventoryIds.LEAD
						}
					);
		}).start();
	}
	
	public void processMaterials()
	{
		if(StatTracker.money < 350)
			return;
		addToInv(InventoryIds.ALUMINIUM, 20);
		addToInv(InventoryIds.METAL, 40);
		addToInv(InventoryIds.LEAD, 30);
		StatTracker.money -= 350;
	}
}
