package backEnd;

import java.util.ArrayList;

public class BaseClass extends DefinedBehavior
{
	int ID = -1;
	protected BaseClass()
	{
		tags = new ArrayList<String>();
	}
	@Override
	protected void addTag(String tag)
	{
		tags.add(tag);
	}
	
	@Override
	protected void Update(){}
	
	@Override
	protected void Draw(){}
	@Override
	public boolean containsTag(String tag)
	{
		for (String i : tags)
		{
			if(i == tag)
				return true;
		}
		return false;
	}
	
	public boolean containsTag(String[] tags)
	{
		for (String i : tags)
		{
			for(int j = 0; j < tags.length; j++)
			{
				if(tags[j] == i)
					return true;
			}
		}
		return false;
	}
	
}
