
public class Robot implements IRobot {
	
	private Battery battery;
	private Motor motor;
	private BallShooter ballShooter;
	
	Robot(Battery aBattery, Motor aMotor, BallShooter aBallShooter )
	{
		battery = aBattery;
		motor = aMotor;
		ballShooter = aBallShooter;
		
		motor.setBattery(battery);
		ballShooter.setBattery(battery);
	}
	
	public boolean getAndShootBallandReturn(int distance)
	{
		boolean madeBasket = false;
		if ( motor.drive(distance) )
		{
			if ( ballShooter.Shoot(distance))
				madeBasket = true;
			
			motor.drive(distance);
		}
		
		return madeBasket;
			
	}
	
	public boolean hasPower()
	{
		return battery.hasPower();
	}

}
