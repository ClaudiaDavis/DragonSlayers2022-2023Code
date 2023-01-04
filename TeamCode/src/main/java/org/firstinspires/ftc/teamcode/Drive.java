package org.firstinspires.ftc.teamcode;

public class Drive {
    /* Class Variables */
    //Nothing yet...

    //Object Creation
    HardwareRobot robot;

    /**
     * Constructor
     */
    public Drive() {
        //Instance Creation
        robot = HardwareRobot.getInstance();
    }

    /**
     * Mecanum Drive movement code
     *
     * double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
     * double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
     * double rightX = gamepad1.right_stick_x;
     * final double v1 = r * Math.cos(robotAngle) + rightX;
     * final double v2 = r * Math.sin(robotAngle) - rightX;
     * final double v3 = r * Math.sin(robotAngle) + rightX;
     * final double v4 = r * Math.cos(robotAngle) - rightX;
     *
     * leftFront.setPower(v1);
     * rightFront.setPower(v2);
     * leftRear.setPower(v3)
     * rightRear.setPower(v4);
     */
    public void mecanumDrive(double drive, double strafe, double turn) {
        //Calculate the powers
        double frontLeftPower  = (drive + strafe + turn);
        double backLeftPower   = (drive - strafe + turn);
        double frontRightPower = (drive - strafe - turn);
        double backRightPower  = (drive + strafe - turn);

        //Clamps the powers



//
//               // Denominator is the largest motor power (absolute value) or 1
//               // This ensures all the powers maintain the same ratio, but only when
//               // at least one is out of the range [-1, 1]


        // Trigonometry Wizardry
        double r = Math.hypot(strafe, drive);
        double robotAngle = Math.atan2(drive, strafe) - Math.PI / 4;
        double rightX = turn;
        //A new variable is created to hold the power because when I tried to continue the variable
        //that calculates the powers the program yelled at me
        final double frontLeftPowerfin = r * Math.cos(robotAngle) + rightX;
        final double backLeftPowerfin = r * Math.sin(robotAngle) - rightX;
        final double frontRightPowerfin = r * Math.sin(robotAngle) + rightX;
        final double backRightPowerfin = r * Math.cos(robotAngle) - rightX;

        //Sets motor power
        robot.frontLeft.setPower(frontLeftPowerfin);
        robot.backLeft.setPower(backLeftPowerfin);
        robot.frontRight.setPower(frontRightPowerfin);
        robot.backRight.setPower(backRightPowerfin);
    }

    /**
     * Autonomous driving
     */
    public void autoForward(double feet, double autoPower) {

        //Feet to ticks
        double target = feetToTicks(feet);
        int targetInteger = (int)target;

        //Sets the desired target position
        robot.frontLeft.setTargetPosition(targetInteger);
        robot.backLeft.setTargetPosition(targetInteger);
        robot.frontRight.setTargetPosition(targetInteger);
        robot.backRight.setTargetPosition(targetInteger);

        //Allow movement
        robot.startAutoMovement();

        //Sets the motor power
        robot.frontLeft.setPower(autoPower);
        robot.backLeft.setPower(autoPower);
        robot.frontRight.setPower(autoPower);
        robot.backRight.setPower(autoPower);

        //Stop movement
        if (robot.frontRight.getCurrentPosition() > (target - 100) ) {
            robot.stopAutoMovement();
        }
    }

    /**
     * Converts feet to encoder ticks
     */
    private double feetToTicks(double targetFeet) {
        final double TICKS_PER_FOOT = 0.00;         //This value is currently unknown
        double ticks = targetFeet * TICKS_PER_FOOT;

        return ticks;
    }
}
