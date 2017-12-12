package BuyActions;

import assemblies.MaterialProcessing;
import backEnd.Assembly;
import backEnd.BaseClass;
import backEnd.Company;
import backEnd.DefinedBehavior;
import backEnd.StatTracker;
import backEnd.shopMenu.BuyButton;
import buttonActions.buttonAction;

public class BuyMaterialProcessing implements buttonAction
{

	int price = 350;
	@Override
	public void playAction(BaseClass referer)
	{
		if(StatTracker.money > price)
		{
			Assembly assembly = new MaterialProcessing();
			DefinedBehavior.appCursor.setHoldable(assembly);getClass();
			Company company = (Company)DefinedBehavior.getController().findByTag("company");
			company.addAssembly(assembly);
			StatTracker.money -= price;
		}
	}

}
