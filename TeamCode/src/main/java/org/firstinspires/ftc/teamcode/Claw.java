package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    /*

The claw operates on a servo. Servos can be tricky, but here is basically what you need to know.

In the INIT phase of your robot, the servo should get set to its default init position. I recommend to test this, plug in the servo and run a code to set its position to 0. Assess whether when the servo position is set to 0 it’s where you want it to be for a default position. If not, you can adjust this number to go up or down to fit the default position.

Next, we need to set up 3 buttons.

Button 1 should reset to this default position when pressed.

Button 2 should set the claw to a position that is equal to a “soft grip”. Ms. Rolon can show you what this means. My advice would be to start with a small number and increase as you test until you find what works.

Button 3 should set the claw to a “hard grip”. Ms. Rolon can show you what this means. I think this value should equal about the same as soft grip + 10 or 15. Play with it and find what works best to actually lift the cones.

Next week we can talk more about the elevator. Hope this helps.


TODO: When off: default is closed hard; when robot is on: open position; three buttons: closed hard, closed soft, and open

     */


    Servo servo;
    private int servo_state;

    public Claw(Servo s) {
        servo = s;

    }
    public void start(){//When the servo starts, it opens
        setOpen();
    }
    public void setClosed() {
        servo.setPosition(0.8);//Depending on how the Servo is set up, the closed is either 0 or 1
    }
    public void setPartial(){
        servo.setPosition(0.69);//nice

    }
    public void setOpen(){
        servo.setPosition(0.0);//Depending on how the Servo is set up, the open is either 0 or 1
       // wait(500);
    }
}
