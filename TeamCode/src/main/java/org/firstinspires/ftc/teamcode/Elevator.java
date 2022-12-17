package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Elevator {

        // Motor objects for the two motors that drive the elevator
        private DcMotor motor1;
        private DcMotor motor2;
        Gamepad gamepad2 = new Gamepad();


        public Elevator(Gamepad g, DcMotor m1, DcMotor m2) {
            // Initialize the two motor objects
            motor1 = m1;
            motor2 = m2;
            gamepad2 = g;
        }

        public void moveUp() {
            // Set the direction of both motors to "up"
            motor1.setDirection(DcMotorSimple.Direction.FORWARD);
            motor2.setDirection(DcMotorSimple.Direction.FORWARD);

            // Start both motors
            //motor1.start();
            //motor2.start();
            }

    public void moveDown() {
        // Set the direction of both motors to "down"
        motor1.setDirection(DcMotorSimple.Direction.REVERSE);
        motor2.setDirection(DcMotorSimple.Direction.REVERSE);

        // Start both motors
        //motor1.start();
        //motor2.start();
    }


        int joystickThreshold = 5;
        boolean running;
        //double y = gamepad2.left_stick_y; // Remember, this is reversed!
        double currentPosition = motor1.getCurrentPosition();
        double MAXROTATION = 100.0; //change when know actual number


        public void moveWithJoystick(){
            while(running) {
                double joystickValue = gamepad2.left_stick_y;
                        //get joy;
                if (joystickValue < joystickThreshold*(-1)) {
                    moveDown();
                }
                else if (joystickValue > joystickThreshold){
                    if (currentPosition < MAXROTATION) {
                        moveUp();
                    }

                }
                else {
                    stop();
                }
            }
        }


        public boolean comeBackHome() {
        boolean doNotMove = false;
        sleep(3000);
         }

        /*

        private EncoderValue motor2CurrentPosition;
        private static final EncoderValue MAXROTATION = 13;
        private static final ENCODERVALUE INIT_POSITION = 0;

        public void moveWithButton() {
            if (isPressed(buttonB)) {
                moveElevatorToMaxPosition();
            }
            else if (isPressed(buttonY)) {
                moveElevatorToStartPosition();
            }
        }

        public void moveElevatorToMaxPosition() {
            while (motor1CurrentPosition != MAXROTATION && motor2CurrentPosition != MAXROTATION) {
                moveUp();
            }
        }

        public void moveElevatorToStartPosition() {
            while (motor1CurrentPosition != INIT_POSITION && motor2CurrentPosition != INIT_POSITION) {
                moveDown();
            }
        }
        */





       // public void stop() {
            // Stop both motors
            //motor1.stop();
            //motor2.stop();
}



