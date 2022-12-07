package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Elevator {

        // Motor objects for the two motors that drive the elevator
        private DcMotor motor1;
        private DcMotor motor2;

        public Elevator(DcMotor m1, DcMotor m2) {
            // Initialize the two motor objects
            motor1 = m1;
            motor2 = m2;
        }

        public void moveUp() {
            // Set the direction of both motors to "up"
            motor1.setDirection(DcMotorSimple.Direction.FORWARD);
            motor2.setDirection(DcMotorSimple.Direction.FORWARD);

            // Start both motors
            motor1.start();
            motor2.start();
        }

        private int joystickThreshold = 5;
        public void moveWithJoystick(){
            while(running) {
                joystickValue = gamepad1.;
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

        public boolean comeBackHome() {
            boolean doNotMove = false;
            sleep(3000);
        }

        public void moveDown() {
            // Set the direction of both motors to "down"
            motor1.setDirection(Direction.DOWN);
            motor2.setDirection(Direction.DOWN);

            // Start both motors
            motor1.start();
            motor2.start();
        }

        public void stop() {
            // Stop both motors
            motor1.stop();
            motor2.stop();
        }
}


