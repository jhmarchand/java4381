package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class RelicRobot9087
{
    /* Public OpMode members. */
    public DcMotor leftFrontDcMotor = null;
    public DcMotor rightFrontDcMotor = null;
    public DcMotor leftRearDcMotor = null;
    public DcMotor rightRearDcMotor = null;

    /* local OpMode members. */
    HardwareMap hardwareMap =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public RelicRobot9087(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap aHardwareMap) {
        // Save reference to Hardware map
        hardwareMap = aHardwareMap;

        // Define and Initialize Motors
        leftFrontDcMotor = hardwareMap.get(DcMotor.class, "left_front_drive");
        rightFrontDcMotor = hardwareMap.get(DcMotor.class, "right_front_drive");
        leftRearDcMotor = hardwareMap.get(DcMotor.class, "left_rear_drive");
        rightRearDcMotor = hardwareMap.get(DcMotor.class, "right_rear_drive");

        leftFrontDcMotor.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightFrontDcMotor.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        leftRearDcMotor.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightRearDcMotor.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors

        // Set all motors to zero power
        leftFrontDcMotor.setPower(0);
        rightFrontDcMotor.setPower(0);
        leftRearDcMotor.setPower(0);
        rightRearDcMotor.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftFrontDcMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFrontDcMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftRearDcMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightRearDcMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

    public void DriveMecanum(double x, double y, double rotation) {
        double leftFrontPower = x + y + rotation;
        double rightFrontPower = -x + y - rotation;
        double leftRearPower = -x + y + rotation;
        double rightRearPower = x + y - rotation;

        double maxPower = Math.max(leftFrontPower, Math.max(rightFrontPower, Math.max(leftRearPower, rightRearPower)));

        if ( maxPower > 1 ){
            leftFrontPower = leftFrontPower / maxPower;
            rightFrontPower = rightRearPower / maxPower;
            leftRearPower = leftRearPower / maxPower;
            rightRearPower = rightRearPower / maxPower;
        }

        leftFrontDcMotor.setPower(leftFrontPower);
        rightFrontDcMotor.setPower(rightFrontPower);
        leftRearDcMotor.setPower(leftRearPower);
        rightRearDcMotor.setPower(rightRearPower);

    }

    public void DriveTank(double left, double right) {
        double leftFrontPower = left;
        double rightFrontPower = right;
        double leftRearPower = left;
        double rightRearPower = right;

         leftFrontDcMotor.setPower(leftFrontPower);
        rightFrontDcMotor.setPower(rightFrontPower);
        leftRearDcMotor.setPower(leftRearPower);
        rightRearDcMotor.setPower(rightRearPower);

    }

 }

