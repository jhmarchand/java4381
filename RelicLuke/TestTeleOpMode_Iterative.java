package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


@TeleOp(name="Test: Teleop Iterative OpMode", group="Iterative Opmode")
public class TestTeleOpMode_Iterative extends OpMode
{

    double max = 1.0;
    // Declare OpMode members.
    private RelicRobot9087 robot = new RelicRobot9087();
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
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {

        //robot.ballSensorServo.setPosition(0.4);
       // robot.ballSensorServo2.setPosition(1.0);

        if ( gamepad1.a)
            max = 1.0;
        if ( gamepad1.b)
            max = 0.25;
        if ( gamepad1.x)
            max = 0.75;
        if ( gamepad1.y)
            max = 0.5;

        if (gamepad2.a)
            robot.squeeze();
        else if (gamepad2.y) {
            robot.partial();
        }
        else if (gamepad2.b)
            robot.open();

      // robot.ballSensorServo2.setPosition(gamepad2.right_stick_y);
        //robot.ballSensorServo.setPosition(1);

       telemetry.addData("servo2", robot.ballSensorServo2.getPosition());

        if (gamepad2.right_trigger >0 )
            robot.forkLifterDcMotor.setPower(gamepad2.right_trigger);
        else if (gamepad2.left_trigger >0)
            robot.forkLifterDcMotor.setPower(gamepad2.left_trigger *-1);
        else
            robot.forkLifterDcMotor.setPower(gamepad2.left_stick_y);

       // String ballColor = "I DON'T KNOW!!!";
//        if (robot.colorSensor.red() > 15 && robot.colorSensor.red() > robot.colorSensor.blue())
       // if ( robot.seeRed())
            //ballColor = "red";
       // if (robot.colorSensor.blue() > 15 && robot.colorSensor.blue() > robot.colorSensor.red())
       // if ( robot.seeBlue() )
           // ballColor = "blue";
       // telemetry.addData("ballColor", ballColor);

        robot.DriveMecanum(gamepad1.left_stick_x*max,-gamepad1.left_stick_y*max, gamepad1.right_stick_x*max*-1);

       telemetry.addData("Color", robot.colorSensor.red());
       telemetry.addData("Color", robot.colorSensor.blue());
        telemetry.addData("Color", robot.colorSensor.green());
      // telemetry.addData("color", robot.colorSensor.alpha());
       telemetry.addData("Distance (cm)", robot.distanceSensor.getDistance(DistanceUnit.CM));
       // robot.DriveTank(-gamepad2.left_stick_y, -gamepad2.right_stick_x);

    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}