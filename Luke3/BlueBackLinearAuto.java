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
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;


@Autonomous(name="blue back linear", group="Pushbot")

public class BlueBackLinearAuto extends LinearOpMode {

    /* Declare OpMode members. */



    RelicRecoveryVuMark vuMark;
    double CypherValue;
    boolean Blue = false;
    double backwards = 0;
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

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Step through each leg of the path, ensuring that the Auto mode has not been stopped along the way

        // Step 1:  Drive forward for 3 seconds
        double driveSpeed = 0.4;
        runtime.reset();

        robot.squeeze();
        robot.ballSensorServo.setPosition(0.85);
        while (opModeIsActive() && (runtime.seconds() < 0.5)) {
            telemetry.addData("Path", "Detecting Ball %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        // Step 2:  Spin right for 1.3 seconds

        robot.forkLifterDcMotor.setPower(-0.75);
        robot.ballSensorServo.setPosition(0.85);
        robot.squeeze();
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            telemetry.addData("Path", "Detecting Ball + lifting block %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            vuMark = robot.vuforiaScan();
            if (vuMark == RelicRecoveryVuMark.RIGHT){
                CypherValue = 0.33;
            }
            else if (vuMark == RelicRecoveryVuMark.LEFT){
                CypherValue = -0.3;
            }

            telemetry.addData("VuMark", "%s visible", vuMark);
        }

        // Step 3:  Drive Backwards for 1 Second
        robot.forkLifterDcMotor.setPower(0);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.6)) {
            telemetry.addData("Path", "Color Detected! Driving %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            if (robot.seeBlue(false) == true || Blue == true) {
                robot.DriveMecanum(0, driveSpeed, 0.05);
                Blue = true;
            }
            else {
                robot.DriveMecanum(0, driveSpeed * -0.5, 0);
                backwards = 1.2;
                Blue = false;
            }

        }
        robot.ballSensorServo.setPosition(0.25);
        robot.DriveMecanum(0,0,0);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.5)) {
            telemetry.addData("Path", "Raising Sensor %2.5f S Elapsed", runtime.seconds());
            telemetry.update();

        }
        robot.DriveMecanum(0,driveSpeed,0);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.335 + backwards + CypherValue)) {
            telemetry.addData("Path", "Driving %2.5f S Elapsed", runtime.seconds());
            telemetry.update();

        }
        robot.DriveMecanum(0,0,0);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.5)) {
            telemetry.addData("Path", "Slowing %2.5f S Elapsed", runtime.seconds());
            telemetry.update();

        }
        driveSpeed = 0.5;
        robot.DriveMecanum(0, 0, driveSpeed);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.25)) {
            telemetry.addData("Path", "Rotating %2.5f S Elapsed", runtime.seconds());
            telemetry.update();

        }
        robot.DriveMecanum(0,driveSpeed * 0.1,0);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.25)) {
            telemetry.addData("Path", "Processing %2.5f S Elapsed", runtime.seconds());
            telemetry.update();

        }
        robot.open();
        robot.DriveMecanum(0,0,0);
        robot.forkLifterDcMotor.setPower(0.75);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.9)) {
            telemetry.addData("Path", "Lowering Forklift %2.5f S Elapsed", runtime.seconds());
            telemetry.update();

        }
        robot.forkLifterDcMotor.setPower(0);
        robot.DriveMecanum(0,driveSpeed,0);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.4)) {
            telemetry.addData("Path", "Driving %2.5f S Elapsed", runtime.seconds());
            telemetry.update();

        }
        robot.DriveMecanum(0,0,0);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            telemetry.addData("Path", "Slowing %2.5f S Elapsed", runtime.seconds());
            telemetry.update();

        }
        robot.DriveMecanum(0,driveSpeed*-1,0);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.1)) {
            telemetry.addData("Path", "Backing up %2.5f S Elapsed", runtime.seconds());
            telemetry.update();

        }
        robot.DriveMecanum(0,0,0);


        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }
}
