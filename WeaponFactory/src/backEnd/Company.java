package backEnd;

import java.util.ArrayList;

import events.event.LoadLayerEvent;

public class Company extends BaseClass implements LoadLayerEvent
{
	String name;
	double totalProfit;
	double currentProfit;
	//ArrayList<Worker>workers();
	ArrayList<Assembly> assemblies;
	//ArrayList<Inventory> inventory;
	Continent continent; // Reference to continent it is situated in
	double totalCosts;
	
	public Company()
	{
		addTag("company");
		assemblies = new ArrayList<Assembly>();
	}
	
	public void addAssembly(Assembly assembly)
	{
		
		assemblies.add(assembly);
	}
	
	String getName()
	{
		return name;
	}
	
	void setName(String name)
	{
		this.name = name;
	}
	
	public Continent GetContinent()
	{
		return continent;
	}
	
	double calculateProfit()
	{
		return currentProfit - totalCosts; 
	}
	/*sellToContinent(Weapon, Continent);
	{
		
	}*/

	@Override
	public void actionLoadLayer()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLayer()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void actionUnloadLayer()
	{
		// TODO Auto-generated method stub
		
	}
	
	/*buyAssembly(Assembly assembly)
	{
		
	}*/
	
	/*buyMaterials(Continent continent, Material material)
	{
		
	}*/
}