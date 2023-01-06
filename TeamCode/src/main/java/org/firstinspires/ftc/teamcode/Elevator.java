package org.firstinspires.ftc.teamcode;
import android.widget.Button;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.internal.android.dx.dex.file.ValueEncoder;
//Old version, push dont work
public class Elevator {
        /*TODO:The motor is actually reversed so change all instances of direction
        forward and vice versa*/

        // Motor objects for the two motors that drive the elevator
        private DcMotor motor1;//this motor is for the elevator
        Gamepad gamepad2 = new Gamepad();

        int joystickThreshold = 5;
        boolean running = false;//This is probably a placeholder for actually starting the motor
        //double y = gamepad2.left_stick_y; // Remember, this is reversed!
        public static final double maxrotationVAL = 180.0; //change when know actual number
        public static final double init_position =  0.0; //change when know actual number

        //private EncoderValue motor2CurrentPosition;
        //private static final EncoderValue MAXROTATION = 13;
        //private static final EncoderValue  INIT_POSITION = 0;



    public Elevator(Gamepad g, DcMotor m1) {
            // Initialize the two motor objects
            motor1 = m1;
            gamepad2 = g;
        }

        public void moveUp() {
            // Set the direction of both motors to "up" then starts the motors (I think)
            if (motor1.getCurrentPosition() < maxrotationVAL){
                motor1.setDirection(DcMotorSimple.Direction.FORWARD);
                running = true;
        }
        }

         public void moveDown() {
         if (motor1.getCurrentPosition() < init_position) {
             motor1.setDirection(DcMotorSimple.Direction.REVERSE);
             running = true;
         }
         }

        public void moveWithJoystick(){ // this garbage and needs to be fixed (I think)
            //running = true;
            //while(running) {
                double joystickValue = gamepad2.left_stick_y;
                //get joy;
                if (joystickValue < joystickThreshold){//Maybe if this does not work put *(-1)?
                    moveDown();
                }
                else if (joystickValue > joystickThreshold){
                    if (motor1.getCurrentPosition() < maxrotationVAL) {
                        moveUp();
                    }
                }
                else {
                  running = false; // someone put "stop();" so maybe something has this function
                                    // and it should be utilized
                }
//            }
        }

   /* public void moveWithJoystick(){ // this garbage and needs to be fixed (I think)
        //running = true;
        //while(running) {
        double joystickValue = gamepad2.left_stick_y;
        //get joy;
        if (joystickValue < joystickThreshold*(-1)) {//Why is it *(-1)? I should ask Claudia
            moveDown();
        }
        else if (joystickValue > joystickThreshold){
            if (motor1.getCurrentPosition() < maxrotationVAL) {
                moveUp();
            }
        }
        else {
            running = false; // someone put "stop();" so maybe something has this function
            // and it should be utilized
        }
//            }
    }

    */


        public void moveWithButton(Button pr) {
            running = true;

            if (gamepad2.b = true  && motor1.getCurrentPosition() < maxrotationVAL ) {
                moveElevatorToMaxPosition();
            }
            else if (gamepad2.y && motor1.getCurrentPosition() < init_position) {
                moveElevatorToStartPosition();
            }
        }

        public void moveElevatorToMaxPosition(){
            while (motor1.getCurrentPosition() != maxrotationVAL) {
                moveUp();
            }
        }

        public void moveElevatorToStartPosition() {
            while (motor1.getCurrentPosition() != init_position) {
                moveDown();
            }
        }
       // public void stop() {
            // Stop both motors
            //motor1.stop();
            //motor2.stop();
}



