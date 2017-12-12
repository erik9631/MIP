package buttonActions;

import backEnd.*;
import events.LoadLayerEventHandler;;
public class BuyCompany implements buttonAction
{

	@Override
	public void playAction(BaseClass referrer)
	{
		Continent continent = (Continent)referrer;
		if(StatTracker.tracker.money > continent.getStartval())
		{
			continent.buyCompany();
			LoadLayerEventHandler.LoadLayer(1);
		}
	}


}
