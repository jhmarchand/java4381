package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="Auto Red Front Team OpMode", group="Iterative Opmode")
public class TestAutoMode_RedFront extends OpMode
{
    boolean Blue = false;
    double backwards = 0;
    double max = 1.0;
    // Declare OpMode members.
    private RelicRobot9087 robot = new RelicRobot9087();
    private ElapsedTime runtime = new ElapsedTime();

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        robot.init(hardwareMap);

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }


    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {

        double driveSpeed = 0.5;

        if (runtime.seconds() <0.5) {
            robot.squeeze();
            robot.ballSensorServo2.setPosition(0.5);

        }
        else if ( runtime.seconds() < 1.5) {
            robot.forkLifterDcMotor.setPower(-0.75);
            robot.ballSensorServo2.setPosition(0.5);
            robot.squeeze();
        }
        else if (runtime.seconds() < 2.0) {
            robot.forkLifterDcMotor.setPower(0);
            if (robot.seeBlue(true) == false || Blue == true) {
                robot.DriveMecanum(0, driveSpeed, 0);
                Blue = true;
            }
            else {
                robot.DriveMecanum(0, driveSpeed * -0.5, 0);
                backwards = 0.7;
                Blue = false;
            }
        }
        else if (runtime.seconds() < 2.6) {
            robot.ballSensorServo2.setPosition(1.0);
            robot.DriveMecanum(0,0,0);
        }
        else if (runtime.seconds() <3.0 + backwards ){
            robot.DriveMecanum(0,driveSpeed,0);
        }
        else if (runtime.seconds() <4.5 + backwards){
            robot.DriveMecanum(0,0,0);
        }
        else if (runtime.seconds() < 6.0 + backwards) {
            driveSpeed = 0.5;
            robot.DriveMecanum(driveSpeed*-1, 0, 0);
        }
        else if (runtime.seconds() < 6.2 + backwards){
            robot.DriveMecanum(0,driveSpeed,0);
        }
        else if (runtime.seconds() < 7.2 + backwards){
            robot.partial();
            robot.DriveMecanum(0,0,0);
        }









    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}