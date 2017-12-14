package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.ConceptVuforiaNavigation;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuMarkInstanceId;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

public class RelicRobot9087 {
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
    //public Servo manAngleServo = null;
    public ColorSensor colorSensor2 = null;
    public DistanceSensor distanceSensor2 = null;
    public Servo ballSensorServo2 = null;
    public Servo extraGrabServo = null;
    public Servo servoSqueezerLeft2 = null;
    public com.qualcomm.robotcore.hardware.CRServo relicLifter = null;
    //public Servo servoSqueezerRight2 = null;
    public static final String TAG = "Vuforia VuMark Sample";

    VuforiaTrackable relicTemplate = null;
    OpenGLMatrix lastLocation = null;
    VuforiaLocalizer vuforia;

    /* local OpMode members. */
    HardwareMap hardwareMap = null;
    private ElapsedTime period = new ElapsedTime();

    /* Constructor */
    public RelicRobot9087() {
    }

    public void init (HardwareMap hardwareMap) {

        leftFrontDcMotor = hardwareMap.get(DcMotor.class,"leftFrontDrive");
        rightFrontDcMotor = hardwareMap.get(DcMotor.class, "rightFrontDrive");
        leftRearDcMotor = hardwareMap.get(DcMotor.class, "leftRearDrive");
        rightRearDcMotor = hardwareMap.get(DcMotor.class, "rightRearDrive");
        forkLifterDcMotor = hardwareMap.get(DcMotor.class, "motor4");
        colorSensor = hardwareMap.get(ColorSensor.class, "sensor");
        distanceSensor = hardwareMap.get(DistanceSensor.class, "sensor");
        servoSqueezerRight = hardwareMap.get(Servo.class, "servo0");
        servoSqueezerLeft = hardwareMap.get(Servo.class, "servo1");
        horizontalSlideDcMotor = hardwareMap.get(DcMotor.class, "motor5");
        ballSensorServo = hardwareMap.get(Servo.class, "servo2");
        manClawServo = hardwareMap.get(Servo.class, "Servo4");
        //manAngleServo = hardwareMap.get(Servo.class, "Servo5");
        colorSensor2 = hardwareMap.get(ColorSensor.class, "sensor1");
        ballSensorServo2 = hardwareMap.get(Servo.class, "servo3");
        extraGrabServo = hardwareMap.get(Servo.class, "grabby");
        servoSqueezerLeft2 = hardwareMap.get(Servo.class, "spicy1");
        //servoSqueezerRight2 = hardwareMap.get(Servo.class, "spicy0");
        relicLifter = hardwareMap.get(CRServo.class, "megaServo");


        leftFrontDcMotor.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightFrontDcMotor.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        leftRearDcMotor.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightRearDcMotor.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors


        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();


        parameters.vuforiaLicenseKey = "AXKhjf//////AAAAGerc4MQPr0fymYJPZNANrWxe1NwZwRFUzWDgsryXic3/sAMhjBbkrQ8809RnsrFq6fvQMzU1Vt8lUuLHGYE5C942kiLtjw8Y8xeXW5lGTYfY46H/KvqpKnRct8cjlQlThNLrwWNMdEWipNF6IMvjZLP3a3L3p/UDnvVRTeX3XWTy7R9WlWN6dCtGmru8WxYuj1kvDgQ5CtJTYOxSDi9NMea9glKuwF960C5RbWEjYgxOwQupp01YDBPzU7l7xKM8VOIgKXvkrGTurCbTzeOG3SZB4vxvNfkomg6jpQQYDh97dJwl/IXZDXDfw5jTJJPmKoZlLVduGYHqiTxUEn2JcZdbIo+PsqWbz4QQBCPHU3hN";


        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.FRONT;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);


        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate"); // can help in debugging; otherwise not necessary


        relicTrackables.activate();

        // Set all motors to zero power
        leftFrontDcMotor.setPower(0);
        rightFrontDcMotor.setPower(0);
        leftRearDcMotor.setPower(0);
        rightRearDcMotor.setPower(0);
        servoSqueezerLeft.setPosition(0.9);
        servoSqueezerRight.setPosition(0.1);
        ballSensorServo.setPosition(0.25);
        ballSensorServo2.setPosition(1);
        manClawServo.setPosition(1);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftFrontDcMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFrontDcMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftRearDcMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightRearDcMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        servoSqueezerLeft.setDirection(Servo.Direction.REVERSE);

    }

    public void DriveMecanum(double x, double y, double rotation) {
        double leftFrontPower = x + y + rotation;
        double rightFrontPower = -x + y - rotation;
        double leftRearPower = -x + y + rotation;
        double rightRearPower = x + y - rotation;

        double maxPower = Math.max(leftFrontPower, Math.max(rightFrontPower, Math.max(leftRearPower, rightRearPower)));

        if (maxPower > 1) {
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

    public RelicRecoveryVuMark vuforiaScan() {
        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
        //telemetry.addData("VuMark", "%s visible", vuMark);
        //telemetry.update();
        return vuMark;
    }

    public void squeeze() {
        extraGrabServo.setPosition(1);
        servoSqueezerLeft.setPosition(0.6);
        servoSqueezerRight.setPosition(1);
        servoSqueezerLeft2.setPosition(0.4);
        //servoSqueezerRight2.setPosition(1);
    }

    public void open() {
        extraGrabServo.setPosition(0.5);
        servoSqueezerLeft.setPosition(0);
        servoSqueezerRight.setPosition(0.5);
        servoSqueezerLeft2.setPosition(1);
        //servoSqueezerRight2.setPosition(0.5);
    }

    public boolean seeRed(boolean useBlueSensor) {
        if (useBlueSensor == false) {
            if (colorSensor2.red() > 15 && colorSensor2.red() > colorSensor2.blue())
                return true;
            else
                return false;
        } else {
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
        extraGrabServo.setPosition(0.5);
        servoSqueezerLeft.setPosition(0.4);
        servoSqueezerRight.setPosition(0.8);
        servoSqueezerLeft2.setPosition(0.6);
        //servoSqueezerRight2.setPosition(0.8);
    }

    public void megaPartial() {
        extraGrabServo.setPosition(0.5);
        servoSqueezerLeft.setPosition(0.5);
        servoSqueezerRight.setPosition(0.9);
        servoSqueezerLeft2.setPosition(0.5);
    }

    public void encoderDrive(LinearOpMode opMode, double speed,
                             int RighttargetPosition, int LeftTargetPosition,
                             double timeoutS, ElapsedTime runtime, boolean stay) {
        int newLeftTarget;
        int newRightTarget;

        // Ensure that the opmode is still active
        if (opMode.opModeIsActive()) {

            // Determine new target position, and pass to motor controller

            leftFrontDcMotor.setTargetPosition(LeftTargetPosition + leftFrontDcMotor.getCurrentPosition());
            leftRearDcMotor.setTargetPosition(LeftTargetPosition + leftRearDcMotor.getCurrentPosition());
            rightFrontDcMotor.setTargetPosition(RighttargetPosition + rightFrontDcMotor.getCurrentPosition());
            rightRearDcMotor.setTargetPosition(RighttargetPosition + rightRearDcMotor.getCurrentPosition());

            // Turn On RUN_TO_POSITION
            leftFrontDcMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightFrontDcMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftRearDcMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightRearDcMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.
            DriveMecanum(0, speed, 0);
            runtime.reset();
            // keep looping while we are still active, and there is time left, and both motors are running.
            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
            // its target position, the motion will stop.  This is "safer" in the event that the robot will
            // always end the motion as soon as possible.
            // However, if you require that BOTH motors have finished their moves before the robot continues
            // onto the next step, use (isBusy() || isBusy()) in the loop test.
            while (opMode.opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (leftFrontDcMotor.isBusy() || rightFrontDcMotor.isBusy() || leftRearDcMotor.isBusy() || rightRearDcMotor.isBusy())) {

                // Display it for the driver.
                opMode.telemetry.addData("Path", "Busy... %2.5f S Elapsed", runtime.seconds());
                opMode.telemetry.addData("Encoder LF", leftFrontDcMotor.getCurrentPosition());
                opMode.telemetry.addData("ENCODER LB", leftRearDcMotor.getCurrentPosition());
                opMode.telemetry.addData("ENCODER RF", rightFrontDcMotor.getCurrentPosition());
                opMode.telemetry.addData("ENCODER RB", rightRearDcMotor.getCurrentPosition());
                opMode.telemetry.addData("distance", RighttargetPosition);
                opMode.telemetry.update();
                if (stay == true && runtime.seconds() >0.4){
                    ballSensorServo.setPosition(0.25);
                    ballSensorServo2.setPosition(1.0);
                }
            }

            // Stop all motion;
            DriveMecanum(0, 0, 0);

            // Turn off RUN_TO_POSITION
            leftFrontDcMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightFrontDcMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            leftRearDcMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightRearDcMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            //  sleep(250);   // optional pause after each move
        }
    }
    public void encoderStrafe(LinearOpMode opMode, double speed,
                             int targetPosition,
                             double timeoutS, ElapsedTime runtime, boolean stay) {
        int newLeftTarget;
        int newRightTarget;

        // Ensure that the opmode is still active
        if (opMode.opModeIsActive()) {

            // Determine new target position, and pass to motor controller

            leftFrontDcMotor.setTargetPosition(-1*targetPosition + leftFrontDcMotor.getCurrentPosition());
            leftRearDcMotor.setTargetPosition(targetPosition + leftRearDcMotor.getCurrentPosition());
            rightFrontDcMotor.setTargetPosition(targetPosition + rightFrontDcMotor.getCurrentPosition());
            rightRearDcMotor.setTargetPosition(-1*targetPosition + rightRearDcMotor.getCurrentPosition());

            // Turn On RUN_TO_POSITION
            leftFrontDcMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightFrontDcMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftRearDcMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightRearDcMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.
            DriveMecanum(0, speed, 0);
            runtime.reset();
            // keep looping while we are still active, and there is time left, and both motors are running.
            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
            // its target position, the motion will stop.  This is "safer" in the event that the robot will
            // always end the motion as soon as possible.
            // However, if you require that BOTH motors have finished their moves before the robot continues
            // onto the next step, use (isBusy() || isBusy()) in the loop test.
            while (opMode.opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (leftFrontDcMotor.isBusy() || rightFrontDcMotor.isBusy() || leftRearDcMotor.isBusy() || rightRearDcMotor.isBusy())) {

                // Display it for the driver.
                opMode.telemetry.addData("Path", "Busy... %2.5f S Elapsed", runtime.seconds());
                opMode.telemetry.addData("Encoder LF", leftFrontDcMotor.getCurrentPosition());
                opMode.telemetry.addData("ENCODER LB", leftRearDcMotor.getCurrentPosition());
                opMode.telemetry.addData("ENCODER RF", rightFrontDcMotor.getCurrentPosition());
                opMode.telemetry.addData("ENCODER RB", rightRearDcMotor.getCurrentPosition());
                opMode.telemetry.addData("distance", targetPosition);
                opMode.telemetry.update();
                if (stay == true && runtime.seconds() >0.4){
                    ballSensorServo.setPosition(0.25);
                    ballSensorServo2.setPosition(1.0);
                }
            }

            // Stop all motion;
            DriveMecanum(0, 0, 0);

            // Turn off RUN_TO_POSITION
            leftFrontDcMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightFrontDcMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            leftRearDcMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightRearDcMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            //  sleep(250);   // optional pause after each move
        }
    }
}
