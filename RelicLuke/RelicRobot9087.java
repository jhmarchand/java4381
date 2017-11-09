package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class RelicRobot9087
{
    /* Public OpMode members. */
    public DcMotor leftFrontDcMotor = null;
    public DcMotor rightFrontDcMotor = null;
    public DcMotor leftRearDcMotor = null;
    public DcMotor rightRearDcMotor = null;
    public DcMotor forkLifterDcMotor = null;
    public DcMotor horizontalSlideDcMotor = null;
    public ColorSensor colorSensor = null;
    public DistanceSensor distanceSensor = null;
    public Servo servoSqueezerRight = null;
    public Servo servoSqueezerLeft = null;
    public Servo ballSensorServo = null;
    public Servo manClawServo = null;
    public Servo manAngleServo = null;
    public ColorSensor colorSensor2 = null;
    public DistanceSensor distanceSensor2 = null;
    public Servo ballSensorServo2 = null;

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
        leftFrontDcMotor = hardwareMap.get(DcMotor.class, "leftFrontDrive");
        rightFrontDcMotor = hardwareMap.get(DcMotor.class, "rightFrontDrive");
        leftRearDcMotor = hardwareMap.get(DcMotor.class, "leftRearDrive");
        rightRearDcMotor = hardwareMap.get(DcMotor.class, "rightRearDrive");
        forkLifterDcMotor = hardwareMap.get(DcMotor.class, "motor4");
       colorSensor = hardwareMap.get(ColorSensor.class, "sensor");
       distanceSensor = hardwareMap.get(DistanceSensor.class, "sensor");
        servoSqueezerRight = hardwareMap.get(Servo.class, "servo0");
        servoSqueezerLeft = hardwareMap.get(Servo.class, "servo1");
       // horizontalSlideDcMotor = hardwareMap.get(DcMotor.class, "motor5");
        ballSensorServo = hardwareMap.get(Servo.class, "servo2");
        //manClawServo = hardwareMap.get(Servo.class, "Servo4");
        //manAngleServo = hardwareMap.get(Servo.class, "Servo5");
        colorSensor2 = hardwareMap.get(ColorSensor.class, "sensor1");
        ballSensorServo2 = hardwareMap.get(Servo.class, "servo3");

        leftFrontDcMotor.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightFrontDcMotor.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        leftRearDcMotor.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightRearDcMotor.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors


        // Set all motors to zero power
        leftFrontDcMotor.setPower(0);
        rightFrontDcMotor.setPower(0);
        leftRearDcMotor.setPower(0);
        rightRearDcMotor.setPower(0);
        servoSqueezerLeft.setPosition(0.9);
        servoSqueezerRight.setPosition(0.1);
        ballSensorServo.setPosition(0.25);
        ballSensorServo2.setPosition(1);
        //manAngleServo.setPosition(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftFrontDcMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFrontDcMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftRearDcMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightRearDcMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        servoSqueezerLeft.setDirection(Servo.Direction.REVERSE);

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
    public void squeeze(){
        servoSqueezerLeft.setPosition(1);
        servoSqueezerRight.setPosition(1);
    }
    public void open(){
        servoSqueezerLeft.setPosition(0.5);
        servoSqueezerRight.setPosition(0.5);
    }
    public boolean seeRed(boolean useBlueSensor) {
        if (useBlueSensor == false) {
            if (colorSensor2.red() > 15 && colorSensor2.red() > colorSensor2.blue())
                return true;
            else
                return false;
        }
        else {
            if (colorSensor.red() > 15 && colorSensor.red() > colorSensor.blue())
                return true;
            else
                return false;
        }
    }
    public boolean seeBlue(boolean useRedSensor) {
        if (useRedSensor == false) {
            if (colorSensor.blue() > 15 && colorSensor.blue() > colorSensor.red())
                return true;
            else
                return false;
        } else {
            if (colorSensor2.blue() > 15 && colorSensor2.blue() > colorSensor2.red())
                return true;
            else
                return false;
        }
    }

        public void partial() {
            servoSqueezerLeft.setPosition(0.8);
            servoSqueezerRight.setPosition(0.8);
        }
    }
