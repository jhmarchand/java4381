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
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;


@TeleOp(name="TeleOp Linear", group="Iterative Opmode")

public class LinearTeleOpENHANCED extends LinearOpMode {

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
    boolean FailSafe = true;
    int random = (int )(Math. random() * 3 + 1);
    boolean claw = false;
    double max = 1.0;
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

        while (opModeIsActive()){
            if (gamepad1.left_bumper|| gamepad1.right_bumper){
                robot.encoderDrive(this,1,2*-1375,2*1375,1.5,runtime,true);
            }
            if (gamepad1.left_stick_button){
                robot.open();
                robot.encoderDrive(this,1,-250,-250,0.5,runtime,true);
                robot.forkLifterDcMotor.setPower(1);
                runtime.reset();
                while (opModeIsActive() && runtime.seconds()<0.5){
                    telemetry.addData("woof", "wait? I'm not a dog");
                    telemetry.update();
                }
                robot.forkLifterDcMotor.setPower(0);
                robot.encoderDrive(this,1,350,350,0.5,runtime,true);
                robot.squeeze();
                robot.forkLifterDcMotor.setPower(-0.75);
                runtime.reset();
                while (opModeIsActive() && runtime.seconds()<0.3){
                    telemetry.addData("woof", "wait? I'm not a dog");
                    telemetry.update();
                }
                robot.forkLifterDcMotor.setPower(0);
            }
            if (gamepad2.dpad_down) {
                robot.manClawServo.setPosition(1);
                claw = false;
            } else if (gamepad2.dpad_up) {
                robot.manClawServo.setPosition(0);
                claw = true;
            }

            robot.horizontalSlideDcMotor.setPower(gamepad2.right_stick_y);

            if (gamepad2.right_bumper) {
                robot.relicLifter.setPower(-1);
            } else if (gamepad2.left_bumper) {
                robot.relicLifter.setPower(1);
            }
            else{
                robot.relicLifter.setPower(0);
            }

            if (gamepad1.a)
                max = 1.0;
            if (gamepad1.b)
                max = 0.25;
            if (gamepad1.x)
                max = 0.75;
            if (gamepad1.y)
                max = 0.5;

            if (gamepad2.a)
                robot.squeeze();
            else if (gamepad2.y) {
                robot.partial();
            } else if (gamepad2.b) {
                robot.open();
            } else if (gamepad2.x) {
                robot.megaPartial();
            }

            // robot.ballSensorServo2.setPosition(gamepad2.right_stick_y);
            //robot.ballSensorServo.setPosition(1);

            telemetry.addData("servo2", robot.ballSensorServo2.getPosition());

            if (gamepad2.right_trigger > 0)
                robot.forkLifterDcMotor.setPower(gamepad2.right_trigger * -1);
            else if (gamepad2.left_trigger > 0)
                robot.forkLifterDcMotor.setPower(gamepad2.left_trigger);
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

            robot.DriveMecanum(gamepad1.left_stick_x * max, -gamepad1.left_stick_y * max, gamepad1.right_stick_x * max * -1);

            //telemetry.addData("Color", robot.colorSensor.red());
            //telemetry.addData("Color", robot.colorSensor.blue());
            //telemetry.addData("Color", robot.colorSensor.green());
            // telemetry.addData("color", robot.colorSensor.alpha());
            //telemetry.addData("Distance (cm)", robot.distanceSensor.getDistance(DistanceUnit.CM));
            // robot.DriveTank(-gamepad2.left_stick_y, -gamepad2.right_stick_x);
            //telemetry.addData("Encoder LF", robot.leftFrontDcMotor.getCurrentPosition());
            //telemetry.addData("ENCODER LB", robot.leftRearDcMotor.getCurrentPosition());
            //telemetry.addData("ENCODER RF", robot.rightFrontDcMotor.getCurrentPosition());
            //telemetry.addData("ENCODER RB", robot.rightRearDcMotor.getCurrentPosition());
            if (random == 1) {
                telemetry.addData("Team 9087", "Go get em!");
            }
            if (random == 2){
                telemetry.addData("Team 9087", "I believe in you!");
            }
            if (random == 3){
                telemetry.addData("Team 9087", "Green team number 1!");
            }
        }

        telemetry.addData("Team 9087", "Autonomous Complete");
        telemetry.update();
        sleep(1000);
    }
}
//LOL Bruh