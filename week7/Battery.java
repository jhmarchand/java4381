
public class Battery {
	
	protected int power;
	
	Battery()
	{
		power = 100;
	}
	
	boolean usePower(int powerUsage)
	{
		if ( power < powerUsage )
		{
			power = 0;
			return false;
		}
		
		power = power - powerUsage;
		
		return true;
	}
	
	boolean hasPower()
	{
		return power > 0;
	}

}
