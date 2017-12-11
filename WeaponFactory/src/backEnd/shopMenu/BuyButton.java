package backEnd.shopMenu;

import java.awt.Button;
import java.awt.Font;
import java.util.IntSummaryStatistics;

import backEnd.Assembly;
import backEnd.BaseClass;
import backEnd.Clickable;
import buttonActions.buttonAction;
import frontEnd.AppButton;
public class BuyButton extends BaseClass implements Clickable
{
	//Class<T> assemblyToCreate;
	AppButton button;
	private int wantedSize = 17;
	private int wantedLenght = 12;
	private Font font;
	buttonAction action;
	int x = 0, y = 0;
	
	public BuyButton(int width, int height, int x, int y, String name, buttonAction action)
	{
		// Constructor should contains reference to the assembly it should create (Via type generic)
		// It should contain the name too.
		super();
		this.x = x;
		this.y = y;
		button = new AppButton(width, height, name, this, siderBar.getPanel());
		this.action = action;
		System.out.println((12*10) / (name.length()) );
		font = new Font("Arial", 0, (int) (wantedLenght*wantedSize / (name.length())) );
				
		button.setFont(font);
	}

	@Override
	public void onClick()
	{
		action.playAction(this);
	}
	
	public void buyAssembly()
	{
		//Assembly crap = new T();
		//statTracker.money -= assembly.getBuyCost();
	}
	@Override
	protected void Draw()
	{
		button.setLocation(x, y);
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
