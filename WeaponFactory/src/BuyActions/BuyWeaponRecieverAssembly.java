package BuyActions;

import assemblies.WeaponRecieverAssembly;
import backEnd.Assembly;
import backEnd.BaseClass;
import backEnd.Company;
import backEnd.DefinedBehavior;
import backEnd.StatTracker;
import buttonActions.buttonAction;

public class BuyWeaponRecieverAssembly implements buttonAction
{

	int price = 750;
	@Override
	public void playAction(BaseClass referer)
	{
		if(StatTracker.money > price)
		{
			Assembly assembly = new WeaponRecieverAssembly();
			DefinedBehavior.appCursor.setHoldable(assembly);getClass();
			Company company = (Company)DefinedBehavior.getController().findByTag("company");
			company.addAssembly(assembly);
			StatTracker.money -= price;
		}
	}

}
