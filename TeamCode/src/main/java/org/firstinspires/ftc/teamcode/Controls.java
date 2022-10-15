package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class Controls {

    /* Enumerator for setting grabber states (words are easier to read than numbers) */
    public static enum GrabberState {
            DEPLOYED,
            RETRACTED;
        }
        GrabberState grabberState = GrabberState.DEPLOYED;

        /* Class Variables */
        double driveSpeedMultiplier = 1.00;
        double tiltSpeedMultiplier  = 0.50;

        //Object Creation
        OpMode logitech;

        /**
         * Constructor
         */
        public Controls(OpMode opmode) {
            //Passes an OpMode into the class (allows for the use of controllers)
            logitech = opmode;
        }

        /**
         * Gamepad 1
         * Controls the driving of the robot
         */
        //TODO: Adam Change this part of the class for mechanum and/or make new mechanum function
        public  double drivePower() {
            double power = -1 * logitech.gamepad1.left_stick_y;

            return power * driveSpeedMultiplier;
        }

        public  double strafePower() {
            double power = logitech.gamepad1.left_stick_x;

            return power * driveSpeedMultiplier;
        }

        public  double turnPower() {
            double power = -1 * logitech.gamepad1.right_stick_x;

            return power * driveSpeedMultiplier;
        }

        /**
         * Controls the Robot's LED's
         */
        public boolean automaticLED() {
            return logitech.gamepad1.a;
        }

        public boolean manualLED() {
            return logitech.gamepad1.b;
        }

        public boolean previousLED() {
            return logitech.gamepad1.left_bumper;
        }

        public boolean nextLED() {
            return logitech.gamepad1.right_bumper;
        }

        /**
         * Gamepad 2
         * Controls the tilt of the manipulator
         */
        public double tiltPower() {
            double power = -1 * logitech.gamepad2.left_stick_y;
            double tiltPower = power * tiltSpeedMultiplier;

            return tiltPower;
        }

        /**
         * Gamepad 2
         * Controls the intake mechanism
         */
        public double intakePower() {
            double power = 0;

            if(logitech.gamepad2.y) {
                power = -0.5;
            }

            double intakePower = power;

            return intakePower;
        }

        /**
         * Gamepad 2
         * Controls the spiny motor
         * @return spinyPower
         */
        public double spinnerPower() {
            //Controller inputs
            float rightTrigger = logitech.gamepad2.right_trigger;
            float leftTrigger  = logitech.gamepad2.left_trigger ;

            //Decides what value to return and incorperates a dead band
            if ( (leftTrigger > 0.1) && (rightTrigger < 0.1) ) {
                return (double)leftTrigger;
            }
            else if ( (leftTrigger < 0.1) && (rightTrigger > 0.1) ) {
                return (double)rightTrigger * -1;
            }
            else {
                return 0.00;
            }
        }

        /**
         * Gamepad 2
         * Sets the position of the grabber servo
         */
        public GrabberState getGrabberPosition() {
            //Gets controller inputs
            boolean rightBumper = logitech.gamepad2.right_bumper;
            boolean leftBumper  = logitech.gamepad2.left_bumper;

            //Checks if the right bumper is pressed
            if (rightBumper == true) {
                //Sets the grabber state to deployed
                grabberState = GrabberState.DEPLOYED;
            }
            //Checks if the left bumper is pressed
            else if (leftBumper == true) {
                //Sets the grabber state to retracted
                grabberState = GrabberState.RETRACTED;
            }

            return grabberState;
        }

}

//End of the Controls class


