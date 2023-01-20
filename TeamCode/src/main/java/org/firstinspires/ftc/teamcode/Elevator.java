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
       // Gamepad g = new Gamepad();

        float joystickThreshold = 0.05f;
        boolean running = false;//This is probably a placeholder for actually starting the motor
        //double y = gamepad2.left_stick_y; // Remember, this is reversed!
        public static final double maxrotationVAL = 180.0; //change when know actual number
        public static final double init_position =  0.0; //change when know actual number;

    public Elevator(Gamepad g, DcMotor m1) {

            // Initialize the two motor objects
            motor1 = m1;
          //  gamepad2 = g;
        }

    public void moveUpFast() {
            // Set the direction of both motors to "up" then starts the motors (I think)
                motor1.setDirection(DcMotorSimple.Direction.REVERSE);
                motor1.setPower(0.5);
                running = true;
    }

    public void moveDownFast() {
         //if (motor1.getCurrentPosition() < init_position) {
             motor1.setDirection(DcMotorSimple.Direction.FORWARD);
             motor1.setPower(0.5);
             running = true;
         //}
    }
    public void moveUpSlow() {
        // Set the direction of both motors to "up" then starts the motors (I think)
        motor1.setDirection(DcMotorSimple.Direction.REVERSE);
        motor1.setPower(0.25);
        running = true;
    }

    public void moveDownSlow() {
        //if (motor1.getCurrentPosition() < init_position) {
        motor1.setDirection(DcMotorSimple.Direction.FORWARD);
        motor1.setPower(0.25);
        running = true;
        //}
    }
    //-128,128
    public void moveWithJoystick(Gamepad joy){ // this garbage and needs to be fixed (I think)
        //running = true;
        //while(running) {
        double joystickLeftValue = joy.left_stick_y;
        double joystickRightValue = joy.right_stick_y;
        //get joy;
        if (joystickLeftValue < (joystickThreshold*-1)) {//Maybe if this does not work put *(-1)?
                    moveDownFast();
        }
        else if (joystickLeftValue > joystickThreshold){
           // if (motor1.getCurrentPosition() < maxrotationVAL) {
                moveUpFast();
         //   }
        }
        else if (joystickRightValue < (joystickThreshold*-1)) {
            moveDownSlow();
        }
        else if (joystickRightValue > joystickThreshold) {
            moveUpSlow();
        }
        else {
            running = false; // someone put "stop();" so maybe something has this function
                                    // and it should be utilized
            motor1.setPower(0);
        }
    }


//    public void moveElevatorToMaxPosition(){
//        while (motor1.getCurrentPosition() != maxrotationVAL) {
//            moveUp();
//        }
//    }

   /* public void comeHome() {
        while(motor1.getCurrentPosition() < init_position){
            moveDown();
        }
    }*/
}

