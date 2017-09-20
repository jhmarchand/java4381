package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;



@TeleOp(name="Test: Teleop Iterative OpMode", group="Iterative Opmode")
public class TestTeleOpMode_Iterative extends OpMode
{
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

        robot.DriveMecanum(gamepad1.left_stick_x,-gamepad1.left_stick_y, gamepad1.right_stick_x);

        robot.DriveTank(-gamepad2.left_stick_y, -gamepad2.right_stick_x);

        if ( gamepad1.a)
            robot.leftFrontDcMotor.setPower(.25);
        if ( gamepad1.b)
            robot.rightFrontDcMotor.setPower(.25);
        if ( gamepad1.x)
            robot.leftRearDcMotor.setPower(.25);
        if ( gamepad1.y)
            robot.rightRearDcMotor.setPower(.25);

    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}
