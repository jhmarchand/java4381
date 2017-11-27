package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;


@Autonomous(name="Auto Red Back Team OpMode", group="Iterative Opmode")

public class TestAutoMode_RedTeam extends OpMode
{
    double CypherValue;
    RelicRecoveryVuMark vuMark;
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



        double driveSpeed = 0.4;

        if (runtime.seconds() <0.5) {
            robot.squeeze();
            robot.ballSensorServo2.setPosition(0.5);

        }
        else if ( runtime.seconds() < 1.5) {
            robot.forkLifterDcMotor.setPower(-0.75);
            robot.ballSensorServo2.setPosition(0.5);
            robot.squeeze();
            vuMark = robot.vuforiaScan();
            if (vuMark == RelicRecoveryVuMark.RIGHT){
                CypherValue = -0.3;
            }
            else if (vuMark == RelicRecoveryVuMark.LEFT){
                CypherValue = 0.33;
            }

            telemetry.addData("VuMark", "%s visible", vuMark);

            //telemetry.update();

        }
        else if (runtime.seconds() < 2.0) {
            robot.forkLifterDcMotor.setPower(0);
            if (robot.seeBlue(true) == false || Blue == true) {
                robot.DriveMecanum(0, driveSpeed, 0.05);
                Blue = true;
            }
            else {
                robot.DriveMecanum(0, driveSpeed * -0.5, 0);
                backwards = 1.25;
                Blue = false;
            }
        }
        else if (runtime.seconds() < 2.6) {
            robot.ballSensorServo2.setPosition(1.0);
            robot.DriveMecanum(0,0,0);
        }
        else if (runtime.seconds() <2.935 + backwards + CypherValue ){
            robot.DriveMecanum(0,driveSpeed,0.05);
        }
        else if (runtime.seconds() <4.5 + backwards+ CypherValue){
            robot.DriveMecanum(0,0,0);
        }
        else if (runtime.seconds() < 5.55 + backwards+ CypherValue) {
            driveSpeed = 0.5;
            robot.DriveMecanum(0, 0, driveSpeed*-1);
        }
        else if (runtime.seconds() < 8.0 + backwards+ CypherValue){
            robot.forkLifterDcMotor.setPower(0.75);
            robot.DriveMecanum(0,driveSpeed * 0.1,0);
        }
        else if (runtime.seconds() < 8.9 + backwards+ CypherValue){
            robot.forkLifterDcMotor.setPower(0);
            robot.open();
            robot.DriveMecanum(0,0,0);
        }
        else if (runtime.seconds() < 9.3 + backwards+ CypherValue) {
            robot.DriveMecanum(0,driveSpeed,0);
        }
        else if (runtime.seconds() < 10.3 + backwards+ CypherValue){
            robot.DriveMecanum(0,0,0);
        }
        else if (runtime.seconds() < 10.4 + backwards+ CypherValue){
            robot.DriveMecanum(0,driveSpeed*-1,0);
        }
        else if (runtime.seconds() < 14.0 + backwards+ CypherValue){
            robot.DriveMecanum(0,0,0);
        }


        telemetry.addData("Cypher Val", CypherValue);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}