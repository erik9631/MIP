package frontEnd;

import java.awt.Color;
import java.awt.Label;

import javax.swing.JLabel;

import backEnd.BaseClass;
import backEnd.DefinedBehavior;

public class TextLabel extends JLabel
{
	BaseClass owner;
	public TextLabel(BaseClass owner)
	{
		this.owner = owner;
		DefinedBehavior.getMainFrame().getPanel().add(this);
		setVisible(true);
		setSize(100, 20);
		//setBackground(new Color(0, 0, 0, 0));
		setEnabled(true);
		setOpaque(false);
	}
}
