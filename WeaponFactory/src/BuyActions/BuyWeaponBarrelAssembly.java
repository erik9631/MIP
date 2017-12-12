package BuyActions;

import assemblies.WeaponBarrelAssembly;
import backEnd.Assembly;
import backEnd.BaseClass;
import backEnd.Company;
import backEnd.DefinedBehavior;
import backEnd.StatTracker;
import buttonActions.buttonAction;

public class BuyWeaponBarrelAssembly implements buttonAction
{

	int price = 350;
	@Override
	public void playAction(BaseClass referer)
	{
		if(StatTracker.money > price)
		{
			Assembly assembly = new WeaponBarrelAssembly();
			DefinedBehavior.appCursor.setHoldable(assembly);getClass();
			Company company = (Company)DefinedBehavior.getController().findByTag("company");
			company.addAssembly(assembly);
			StatTracker.money -= price;
		}
	}

}
