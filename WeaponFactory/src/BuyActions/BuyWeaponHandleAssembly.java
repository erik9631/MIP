package BuyActions;

import assemblies.WeaponHandleAssembly;
import backEnd.Assembly;
import backEnd.BaseClass;
import backEnd.Company;
import backEnd.DefinedBehavior;
import backEnd.StatTracker;
import buttonActions.buttonAction;

public class BuyWeaponHandleAssembly implements buttonAction
{

	int price = 550;
	@Override
	public void playAction(BaseClass referer)
	{
		if(StatTracker.money > price)
		{
			Assembly assembly = new WeaponHandleAssembly();
			DefinedBehavior.appCursor.setHoldable(assembly);getClass();
			Company company = (Company)DefinedBehavior.getController().findByTag("company");
			company.addAssembly(assembly);
			StatTracker.money -= price;
		}
	}

}
