/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;


@Autonomous(name="Blue Front encoder", group="Pushbot")

public class BlueFrontEncoder extends LinearOpMode {

    /* Declare OpMode members. */

    static final double     COUNTS_PER_MOTOR_REV    = 1440 ;    // eg: TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 2.0 ;     // This is < 1.0 if geared UP
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double     DRIVE_SPEED             = 0.5;
    static final double     TURN_SPEED              = 0.5;
    double right = 0;
    RelicRecoveryVuMark vuMark;
    int CypherValue;
    int strafeyTeamo;
    boolean Blue = false;
    int backwards = 0;
    double max = 1.0;
    boolean FailSafe = true;
    // Declare OpMode members.
    private RelicRobot9087 robot = new RelicRobot9087();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        waitForStart();

        robot.leftFrontDcMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftRearDcMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightFrontDcMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightRearDcMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // Step through each leg of the path, ensuring that the Auto mode has not been stopped along the way

        // Step 1:  Drive forward for 3 seconds
        double driveSpeed = 0.4;
        runtime.reset();

        robot.forkLifterDcMotor.setPower(-0.75);
        robot.squeeze();
        robot.ballSensorServo.setPosition(0.78);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            telemetry.addData("Path", "lifting block %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            vuMark = robot.vuforiaScan();
            if (vuMark == RelicRecoveryVuMark.RIGHT){
                CypherValue = -700;
                right = 0.2;
                strafeyTeamo = 0;
            }
            else if (vuMark == RelicRecoveryVuMark.LEFT){
                CypherValue = 550;
                strafeyTeamo = -2300;

            }
            else if (vuMark == RelicRecoveryVuMark.CENTER|| vuMark == RelicRecoveryVuMark.UNKNOWN){
                strafeyTeamo = -800;
                CypherValue = 0;
            }

            telemetry.addData("VuMark", "%s visible", vuMark);
        }
        robot.forkLifterDcMotor.setPower(0);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.5)) {
            telemetry.addData("Path", "sensing color! %2.5f S Elapsed", runtime.seconds());
            telemetry.update();

        }
        runtime.reset();
        if (robot.seeBlue(false) == true && robot.seeRed(true) == false) {
            //robot.encoderDrive(this, DRIVE_SPEED, 500, 500, 1, runtime);
            //backwards = -500;
            FailSafe = false;
        }
        else if (robot.seeBlue(false) == false && robot.seeRed(true) == true) {
            robot.encoderDrive(this, DRIVE_SPEED, -130, 130, .7, runtime,false);
            //backwards = 500;
            robot.ballSensorServo.setPosition(0.25);
            robot.encoderDrive(this, DRIVE_SPEED, 130, -130, .7, runtime,true);
            //:)
        }
        if (FailSafe == true){
            robot.ballSensorServo2.setPosition(1.0);
        }


        robot.encoderDrive(this, DRIVE_SPEED, 1700 + backwards,1700 + backwards, 3.5, runtime,true);

        robot.encoderStrafe(this, DRIVE_SPEED, -1000 + CypherValue, 3, runtime,false);



        robot.encoderDrive(this, DRIVE_SPEED, 500,500, 1, runtime,false);
        robot.open();
        robot.encoderDrive(this,DRIVE_SPEED, -200, -200, 2,runtime,false);
       robot.forkLifterDcMotor.setPower(0.75);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.5)) {
            telemetry.addData("Path", "Lowering Forklift! %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        robot.forkLifterDcMotor.setPower(0);
        robot.encoderStrafe(this,DRIVE_SPEED*2,-1500 + strafeyTeamo,1.5,runtime,false);
        robot.encoderDrive(this, DRIVE_SPEED*2, 2*1400, 2*-1400, 1.5, runtime,false);
        robot.partial();
        robot.encoderDrive(this, DRIVE_SPEED*2, 2800, 2800, 1, runtime,false);
        robot.squeeze();
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.5)) {
            telemetry.addData("Path", "LIFTING THE BLOCK!!! %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        robot.forkLifterDcMotor.setPower(-1);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.3)) {
            telemetry.addData("Path", "LIFTING THE BLOCK!!! %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        robot.forkLifterDcMotor.setPower(0);
        robot.encoderDrive(this,DRIVE_SPEED*2, -1900, -1900, 1,runtime,false);
        robot.encoderDrive(this, DRIVE_SPEED*2, -2*1400, 2*1400, 1.5, runtime,false);
        //robot.encoderDrive(this, DRIVE_SPEED*2, 600, 600, 0.5, runtime,false);
        robot.encoderStrafe(this,DRIVE_SPEED*2,1230,1,runtime,false);
        robot.forkLifterDcMotor.setPower(-1);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.2)) {
            telemetry.addData("Path", "LIFTING THE BLOCK!!! %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        robot.forkLifterDcMotor.setPower(0);

        robot.encoderDrive(this,DRIVE_SPEED*2,675,675,0.5,runtime,false);
        robot.open();
        robot.encoderDrive(this,DRIVE_SPEED*2,-200,-200,0.5,runtime,false);
        robot.forkLifterDcMotor.setPower(1);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.5)) {
            telemetry.addData("Path", "LIFTING THE BLOCK!!! %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        robot.forkLifterDcMotor.setPower(0);


        telemetry.addData("Team 9087", "Autonomous Complete");
        telemetry.update();
        sleep(1000);
    }
}
//LOL Bruh