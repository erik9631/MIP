package frontEnd;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.ReplicateScaleFilter;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import backEnd.Clickable;
import backEnd.DefinedBehavior;

public class AppButton extends JButton implements MouseInputListener
{
	//Add reference to panel and add this button to the panel in the constructor to make it work
	// Reference to main panel in the baseclass is not required.
	Clickable subscriber;
	public AppButton(int width, int height, String name, Clickable subscriber)
	{
		this.subscriber = subscriber;
		setSize(width, height);
		setVisible(true);
		if(name != null)
			name.replaceAll("\n", "<br>");
		setText("<html>" + name + "</html>");
		DefinedBehavior.getMainFrame().getPanel().add(this);
		addMouseListener(this);
		addMouseMotionListener(this);

	}
	
	public AppButton(int width, int height, String name, Clickable subscriber, JPanel panel)
	{
		this.subscriber = subscriber;
		setSize(width, height);
		setVisible(true);
		setText("<html>" + name + "</html>");
		panel.add(this);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		subscriber.onMouseExit();
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		if(arg0.getButton() == 1)
			subscriber.onClick();
		else if(arg0.getButton() == 3)
			subscriber.onRightClick();		
	}

	@Override
	public void mouseDragged(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0)
	{
		subscriber.onHover();
	}
	
}
