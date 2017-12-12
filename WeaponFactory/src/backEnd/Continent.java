package backEnd;
import frontEnd.AppButton;
import buttonActions.*;
import events.LoadLayerEventHandler;
import events.event.LoadLayerEvent;
public class Continent extends BaseClass implements Clickable, LoadLayerEvent
{
	Company company;
	//ArrayList<WeaponPrice>(); //WeaponPrice class that includes ID and price
	//Inventory inventory; // Inventory contains inventoryItem class that includes the amount of weapons that the continent
							//Owns. Based on that value it calculates the number of weapons required which affects the price.
	private String name;
	protected int startVal;
	//Gui Variables
	int layer = 0; //Graphical layer to load
	buttonAction action; // Current button action
	AppButton button;
	
	int x = 0, y = 0;
	
	@Override
	public void onClick()
	{
		action.playAction(this);
	}
	
	public int getStartval()
	{
		return startVal;
	}
	
	public void buyCompany()
	{
		company = new Company();
		StatTracker.money -= startVal;
		System.out.println("Company bought");
		//buttonAction = new LoadCompany Action....
	}
	
	void setGraphicsEnabled(boolean enabled)
	{
		button.setEnabled(enabled);
		button.setVisible(enabled);
	}
	
	void updateGuiVals()
	{
		button.setText(name);
	}
	
	public Continent()
	{
		super();
		LoadLayerEventHandler.subscribe(this);
		button = new AppButton(100, 50, name, this);
		addTag("continent");
		action = new BuyCompany();
	}
	@Override
	protected void Update()
	{
		/*x += (int)controller.getTimeDelta() * 0.1;
		System.out.println(x);*/
	}
	@Override
	protected void Draw()
	{
		button.setLocation(x, y);
		//System.out.println(controller.getFrameRate());
	}
	
	// Getters
	public String GetName()
	{
		return name;
	}
	
	//Setters
	public void setName(String name)
	{
		this.name = name;
		updateGuiVals();
	}
	
	public void setPosition(int x, int y)
	{
		this.x = x;
		this.y = y;
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
	public void onRightClick()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHover()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseExit()
	{
		// TODO Auto-generated method stub
		
	}

}
