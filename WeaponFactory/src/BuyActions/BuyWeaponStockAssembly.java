package BuyActions;

import assemblies.MaterialProcessing;
import assemblies.WeaponStockAssembly;
import backEnd.Assembly;
import backEnd.BaseClass;
import backEnd.Company;
import backEnd.DefinedBehavior;
import backEnd.StatTracker;
import backEnd.shopMenu.BuyButton;
import buttonActions.buttonAction;

public class BuyWeaponStockAssembly implements buttonAction
{

	int price = 350;
	@Override
	public void playAction(BaseClass referer)
	{
		if(StatTracker.money > price)
		{
			Assembly assembly = new WeaponStockAssembly();
			DefinedBehavior.appCursor.setHoldable(assembly);getClass();
			Company company = (Company)DefinedBehavior.getController().findByTag("company");
			company.addAssembly(assembly);
			StatTracker.money -= price;
		}
	}

}
