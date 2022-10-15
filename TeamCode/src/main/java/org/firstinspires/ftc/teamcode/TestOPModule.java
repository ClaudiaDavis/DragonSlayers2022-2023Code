package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;



public abstract class TestOPModule extends LinearOpMode {
//       private Gyroscope imu;
//       private DcMotor motorTest ;
//       private DigitalChannel digitalTouch;
//       private DistanceSensor sensorColorRange;
//       private Servo servoTest;

    private DcMotor leftMotor = null ;
    private DcMotor rightMotor = null;

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
               double y = -gamepad1.left_stick_y; // Remember, this is reversed!
               double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
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

               // Gamepad 1 inputs
//               OpMode operator1; //= new OpMode();
//
//               gamepad1 = gamepad1;
//
//               Controls cont1 = new Controls(this); // find or create OP mode to put here, should be driver control.
//               double leftStickY = cont1.drivePower();
//               double leftStickX = cont1.strafePower();
//               double rightStickX = cont1.turnPower();
//
//               //Mecanum Drive Method
//               Drive driver1 = new Drive();
//               driver1.mecanumDrive(leftStickY, leftStickX, rightStickX);


           }








        }
    }



