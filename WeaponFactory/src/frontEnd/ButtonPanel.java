package frontEnd;
import java.awt.Color;
import javax.swing.JPanel;
import backEnd.DefinedBehavior;

public class ButtonPanel extends JPanel
{
	int x, y;
	public ButtonPanel()
	{
		setLayout(null);
		setBackground(Color.gray);
		setLocation(0, 0);
		setSize(800, 800);
		DefinedBehavior.getMainFrame().getPanel().add(this);
	}
}
