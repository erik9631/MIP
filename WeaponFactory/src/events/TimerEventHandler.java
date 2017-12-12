package events;
import backEnd.BaseClass;

public class TimerEventHandler extends BaseClass
{
	long time;
	long currentTime;
	boolean loop;
	Runnable implementation;
	boolean start;
	public TimerEventHandler(long time, boolean loop, Runnable implementation)
	{
		this.time = time;
		this.loop = loop;
		currentTime = System.currentTimeMillis();
		System.out.println("Timer created");
		this.implementation = implementation;
	}

	public void setTime(long time)
	{
		this.time = time;
	}
	
	@Override
	protected void Update()
	{
		if(start == true && currentTime < System.currentTimeMillis())
		{
			updateTimer();
		}
	}
	
	public void start()
	{
		start = true;
	}
	
	public void stop()
	{
		start = false;
	}
	
	private void updateTimer()
	{
		currentTime = time + System.currentTimeMillis();
		implementation.run();
	}
}
