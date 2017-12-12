package inventory;
import java.util.ArrayList;

public class Inventory
{
	ArrayList<InventoryItem> inv;
	public Inventory()
	{
		inv = new ArrayList<InventoryItem>();
	}
	/* TODO
	 * Add functions to manage inventory. Add item to inventory, remove item from inventory. Based on ID or reference.
	 * Make functions that display the inventory and its content. Connect it to inventory Gui Class.
	 * Inventory has to be attachable. To whatever object it is attached, it will try to display its inventory content
	 * Items need a CreateInventoryItem function, which is called by this class and it creates the inv item
	 * They also need a CreateFromInventory function, which makes a new object of that type and loads the variables
	 * from the memory
	 */
}
