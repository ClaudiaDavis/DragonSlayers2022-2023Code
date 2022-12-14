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


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;


//import com.qualcomm.robotcore.eventloop.opmode.Disabled;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.util.Range;

/**
 * This particular OpMode executes a POV Game style Teleop for a direct drive robot
 * The code is structured as a LinearOpMode
 *
 * In this mode the left stick moves the robot FWD and back, the Right stick turns left and right.
 * It raises and lowers the arm using the Gamepad Y and A buttons respectively.
 * It also opens and closes the claws slowly using the left and right Bumper buttons.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="Robot: TeleOp Test 1", group="Robot")
//@Disabled
public class RobotTeleopPOV_Linear_TestDrive extends LinearOpMode {
    private Gyroscope imu;
//       private DcMotor motorTest ;
//       private DigitalChannel digitalTouch;
//       private DistanceSensor sensorColorRange;
//       private Servo servoTest;

//    private DcMotor leftMotor = null;
//    private DcMotor rightMotor = null;
    //private OpMode TeleOp;

    public void runOpMode() {
//           imu = hardwareMap.get(Gyroscope.class, "imu");
//           motorTest = hardwareMap.get(DcMotor.class, "motorTest");
//           digitalTouch = hardwareMap.get(DigitalChannel.class, "digitalTouch");
//           sensorColorRange = hardwareMap.get(DistanceSensor.class, "sensorColorRange");
//           servoTest = hardwareMap.get(Servo.class, "servoTest");
//TODO: Add initialization code as necessary
        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
        DcMotor motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        DcMotor motorBackRight = hardwareMap.dcMotor.get("motorBackRight");
        Servo clawServo = hardwareMap.servo.get("clawMotor");
<<<<<<< HEAD
=======
        DcMotor liftMotor1 = hardwareMap.dcMotor.get("liftMotor1");
        DcMotor liftMotor2 = hardwareMap.dcMotor.get("liftMotor2");
>>>>>>> 1269a6b8dc7fb2e1032ddb38011ff62fafe43dbf

        // Reverse the right side motors
        // Reverse left motors if you are using NeveRests
        motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBackRight.setDirection(DcMotorSimple.Direction.REVERSE);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        if (isStopRequested()) return;

        while (opModeIsActive()) {
            //Driving:
            double y = gamepad1.left_stick_y; // Remember, this is reversed!
            double x = -gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            motorFrontLeft.setPower(frontLeftPower);
            motorBackLeft.setPower(backLeftPower);
            motorFrontRight.setPower(frontRightPower);
            motorBackRight.setPower(backRightPower);

<<<<<<< HEAD
            //Claw Code

            boolean open = gamepad2.a;
            boolean softclose = gamepad2.y;
            boolean hardclose = gamepad2.b;



            Claw claw = new Claw(gamepad2, clawServo);

            if(open) {
                claw.open();
            }
            else if(softclose){
                claw.closeSoft();
            }
            else if(hardclose){
                claw.closeHard();
            }
            else{
                claw.closeSoft();
=======
            //Elevator Code
            //double liftVariable = gamepad2.left_stick_y;
            boolean comehome = gamepad2.x;
            Elevator lift = new Elevator(gamepad2, liftMotor1);

            lift.moveWithJoystick();
            if (comehome){
                lift.comeHome();
            }




            //Claw Code

            boolean buttonA= gamepad2.a;
            boolean buttonY = gamepad2.y;
            boolean buttonB = gamepad2.b;

            Claw claw = new Claw(gamepad2, clawServo);

            if(buttonA) {
                claw.setOpen();
            }
            else if(buttonY){
                claw.setPartial();
            }
            else if(buttonB){
                claw.setClosed();
            }
            else{
                claw.setPartial();
>>>>>>> 1269a6b8dc7fb2e1032ddb38011ff62fafe43dbf
            }






            // Gamepad 1 inputs

//            Controls cont1 = new Controls(this); // find or create OP mode to put here, should be driver control.
//            double leftStickY = cont1.drivePower();
//            double leftStickX = cont1.strafePower();
//            double rightStickX = cont1.turnPower();
//
//            //Mecanum Drive Method
//            Drive driver1 = new Drive();
//            driver1.mecanumDrive(leftStickY, leftStickX, rightStickX);


        }


        //
//    /* Declare OpMode members. */
//    public DcMotor  leftDrive   = null;
//    public DcMotor  rightDrive  = null;
//    public DcMotor  leftArm     = null;
//    //public Servo    leftClaw    = null;
//    //public Servo    rightClaw   = null;
//
//    double clawOffset = 0;
////
////    public static final double MID_SERVO   =  0.5 ;
////    public static final double CLAW_SPEED  = 0.02 ;                 // sets rate to move servo
////    public static final double ARM_UP_POWER    =  0.45 ;
////    public static final double ARM_DOWN_POWER  = -0.45 ;
//
//    @Override
//    public void runOpMode() {
//        double left;
//        double right;
//        double drive;
//        double turn;
//        double max;
//
//        // Define and Initialize Motors
//        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
//        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
//        leftArm    = hardwareMap.get(DcMotor.class, "left_arm");
//
//        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
//        // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
//        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
//        leftDrive.setDirection(DcMotor.Direction.REVERSE);
//        rightDrive.setDirection(DcMotor.Direction.FORWARD);
//
//        // If there are encoders connected, switch to RUN_USING_ENCODER mode for greater accuracy
//        // leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        // rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//
//        // Define and initialize ALL installed servos.
////        leftClaw  = hardwareMap.get(Servo.class, "left_hand");
////        rightClaw = hardwareMap.get(Servo.class, "right_hand");
////        leftClaw.setPosition(MID_SERVO);
////        rightClaw.setPosition(MID_SERVO);
//
//        // Send telemetry message to signify robot waiting;
//        telemetry.addData(">", "Robot Ready.  Press Play.");    //
//        telemetry.update();
//
//        // Wait for the game to start (driver presses PLAY)
//        waitForStart();
//
//        // run until the end of the match (driver presses STOP)
//        while (opModeIsActive()) {
//
//            // Run wheels in POV mode (note: The joystick goes negative when pushed forward, so negate it)
//            // In this mode the Left stick moves the robot fwd and back, the Right stick turns left and right.
//            // This way it's also easy to just drive straight, or just turn.
//            drive = -gamepad1.left_stick_y;
//            turn  =  gamepad1.right_stick_x;
//
//            // Combine drive and turn for blended motion.
//            left  = drive + turn;
//            right = drive - turn;
//
//            // Normalize the values so neither exceed +/- 1.0
//            max = Math.max(Math.abs(left), Math.abs(right));
//            if (max > 1.0)
//            {
//                left /= max;
//                right /= max;
//            }
//
//            // Output the safe vales to the motor drives.
//            leftDrive.setPower(left);
//            rightDrive.setPower(right);
//
//            // Use gamepad left & right Bumpers to open and close the claw
//            if (gamepad1.right_bumper)
//                clawOffset += CLAW_SPEED;
//            else if (gamepad1.left_bumper)
//                clawOffset -= CLAW_SPEED;
//
//            // Move both servos to new position.  Assume servos are mirror image of each other.
//            clawOffset = Range.clip(clawOffset, -0.5, 0.5);
//            leftClaw.setPosition(MID_SERVO + clawOffset);
//            rightClaw.setPosition(MID_SERVO - clawOffset);
//
//            // Use gamepad buttons to move arm up (Y) and down (A)
//            if (gamepad1.y)
//                leftArm.setPower(ARM_UP_POWER);
//            else if (gamepad1.a)
//                leftArm.setPower(ARM_DOWN_POWER);
//            else
//                leftArm.setPower(0.0);
//
//            // Send telemetry message to signify robot running;
//            telemetry.addData("claw",  "Offset = %.2f", clawOffset);
//            telemetry.addData("left",  "%.2f", left);
//            telemetry.addData("right", "%.2f", right);
//            telemetry.update();
//
//            // Pace this loop so jaw action is reasonable speed.
//            sleep(50);
//        }
//    }
    }
}
