import java.util.Scanner;

public class RobotGameMain {

	public static void main(String[] args) {

		
		Robot robotA = new Robot(new Battery(), new Motor(), new BallShooter());
		Robot robotB = new Robot(new Battery(), new Motor(), new BallShooter());

		playGame(robotA, robotB);
	}

	private static void playGame(IRobot robotA, IRobot robotB) {
		Scanner input = new Scanner(System.in);
		int distanceToBall = 0;
		
		int aPoints = 0;
		int bPoints = 0;
		
		int round = 1;
		
		while ( robotA.hasPower() || robotB.hasPower() ) 
		{
			if ( robotA.hasPower() )
			{
				distanceToBall = GetBallThrow();
				System.out.println("Robot A ball thrown " + distanceToBall + " feet.");
				if (robotA.getAndShootBallandReturn(distanceToBall))
				{
					aPoints++;
					System.out.println("Robot A made a basket!");
				}
				else
				{
					System.out.println("Robot A missed!");
				}
			}
			else
			{
				System.out.println("Robot A out of power!");
			}			
			
			if ( robotB.hasPower() )
			{
				distanceToBall = GetBallThrow();
				System.out.println("Robot B ball thrown " + distanceToBall + " feet.");
				if (robotB.getAndShootBallandReturn(distanceToBall))
				{
					bPoints++;
					System.out.println("Robot B made a basket!");
				}
				else
				{
					System.out.println("Robot B missed!");
				}
			}
			else
			{
				System.out.println("Robot B out of power!");
			}			
			
			System.out.println("End of round " + round);
			System.out.println("Score: RobotA " + aPoints + " RobotB " + bPoints);
			System.out.println("Hit enter to go to next round");
			input.nextLine();
			round++;
		}
		
		System.out.println("Game over!");
		System.out.println("Score: RobotA " + aPoints + " RobotB " + bPoints);
		input.close();
	}
	
	static int GetBallThrow()
	{
		return (int) (Math.random() * 10) + 1;
	}

}
