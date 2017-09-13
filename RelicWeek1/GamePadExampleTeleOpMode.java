package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Basic: POV Iterative", group="Iterative Opmode")
@Disabled
public class GamePadExampleTeleOpMode extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;

    // Code to run ONCE when the driver hits INIT
    @Override
    public void init() {
        telemetry.addData("Status", "Initializing");

        // Set up Motors
        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");

        // For Motors that are mounted backwards, we have to set the direction to be reverse
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
    }


    // Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
    @Override
    public void init_loop() {
    }

    // Code to run ONCE when the driver hits PLAY
    @Override
    public void start() {
        runtime.reset();
    }

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    @Override
    public void loop() {

        double gamepadDouble;
        boolean gamepadBoolean;

        gamepadDouble = gamepad1.left_stick_x;
        gamepadDouble = gamepad1.left_stick_y;

        gamepadDouble = gamepad1.right_stick_x;
        gamepadDouble = gamepad1.right_stick_y;

        gamepadDouble = gamepad1.right_trigger;
        gamepadDouble = gamepad1.left_trigger;

        gamepadBoolean = gamepad1.a;
        gamepadBoolean = gamepad1.b;
        gamepadBoolean = gamepad1.x;
        gamepadBoolean = gamepad1.y;

        gamepadBoolean = gamepad1.dpad_down;
        gamepadBoolean = gamepad1.dpad_up;
        gamepadBoolean = gamepad1.dpad_left;
        gamepadBoolean = gamepad1.dpad_right;

        gamepadBoolean = gamepad1.left_bumper;
        gamepadBoolean = gamepad1.right_bumper;

        gamepadBoolean = gamepad1.left_stick_button;
        gamepadBoolean = gamepad1.right_stick_button;


        // calculate Power for motors
        double drive = -gamepad1.left_stick_y;
        double turn  =  gamepad1.right_stick_x;
        double leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
        double rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

        // Send calculated power to wheels
        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);

        // Show the elapsed game time and wheel power.
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
    }

    // Code to run ONCE after the driver hits STOP
    @Override
    public void stop() {
    }

}
