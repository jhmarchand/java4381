
public class Motor {
	
	final static double powerUsagePerFoot = 1.7;
	
	private Battery battery;
	
	Motor()
	{
		battery = null;
	}
	
	Motor(Battery aBattery)
	{
		battery = aBattery;
	}
	
	void setBattery(Battery aBattery)
	{
		battery = aBattery;
	}
	
	boolean drive(int feet)
	{
		int neededPower = (int) powerUsagePerFoot * feet;
		if ( battery.usePower(neededPower) )
			return true;
		
		return false;
	}

}
