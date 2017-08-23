
public class BallShooter {
	
	final static int powerUsage = 3;
	
	final static int hitPercentage = 80;
	
	private Battery battery;
	
	BallShooter()
	{
		battery = null;
	}
	
	BallShooter(Battery aBattery)
	{
		battery = aBattery;
	}
	
	void setBattery(Battery aBattery)
	{
		battery = aBattery;
	}
	
	boolean Shoot(int distance)
	{
		if ( !battery.usePower(powerUsage))
			return false;
		
		int chance = (int) (Math.random() * 100) + 1;
		
		if ( chance > hitPercentage - 5 * distance )
			return false;
		else 
			return true;
	}

}
