package backEnd;

import frontEnd.MainFrame;

public class Main
{

	public static void main(String[] args)
	{
		MainFrame mainFrame = new MainFrame();
		ApplicationController controller = new ApplicationController(mainFrame);
		Engine.init();
		while(true)
		{
			controller.Update();
		}
	}

}
