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


@Autonomous(name="Red back encoder", group="Pushbot")

public class RedBackEncoder extends LinearOpMode {

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
    boolean Blue = false;
    int backwards = 0;
    double max = 1.0;
    // Declare OpMode members.
    private RelicRobot9087 robot = new RelicRobot9087();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {

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
        robot.ballSensorServo2.setPosition(0.5);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            telemetry.addData("Path", "lifting block %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            vuMark = robot.vuforiaScan();
            if (vuMark == RelicRecoveryVuMark.RIGHT){
                CypherValue = -475;
                right = 0.2;
            }
            else if (vuMark == RelicRecoveryVuMark.LEFT){
                CypherValue = 475;
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
        if (robot.seeBlue(true) == false) {
            robot.encoderDrive(this, DRIVE_SPEED, 500, 500, 0.5, runtime);

        }
        else if (robot.seeBlue(true) == true) {
            robot.encoderDrive(this, DRIVE_SPEED, -500, -500, 0.5, runtime);
            backwards = 1000;

        }
        robot.ballSensorServo2.setPosition(1.0);
        robot.encoderDrive(this, DRIVE_SPEED, 2368 + CypherValue + backwards,2368+ CypherValue + backwards, 2, runtime);

        robot.encoderDrive(this, DRIVE_SPEED, 1375, -1375, 1.5, runtime);

        robot.encoderDrive(this, DRIVE_SPEED, 500,500, .5, runtime);
        robot.open();
        robot.encoderDrive(this,DRIVE_SPEED, -1000, -1000, 0.75,runtime);
        robot.encoderDrive(this, DRIVE_SPEED, 2*1375, 2*-1375, 3.0, runtime);
        robot.partial();
        robot.encoderDrive(this, DRIVE_SPEED, 2000, 2000, 3.0, runtime);
        robot.squeeze();
        robot.forkLifterDcMotor.setPower(1);
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            telemetry.addData("Path", "LIFTING THE BLOCK!!! %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        robot.encoderDrive(this,DRIVE_SPEED, -1000, -1000, 0.75,runtime);
        robot.encoderDrive(this, DRIVE_SPEED, 2*1375, 2*-1375, 3.0, runtime);
        robot.encoderDrive(this, DRIVE_SPEED, 2500, 2500, 3.0, runtime);
        robot.open();
        robot.encoderDrive(this,DRIVE_SPEED,-500,-500,0.5,runtime);

        telemetry.addData("Whew!", "Good work People!");
        telemetry.update();
        sleep(1000);
    }
}
