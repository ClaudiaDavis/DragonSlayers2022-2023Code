package org.firstinspires.ftc.teamcode;
//THIS IS UNFINISHED

import android.graphics.Color;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;





import org.firstinspires.ftc.robotcontroller.external.samples.SensorColor;
import org.openftc.easyopencv.OpenCvPipeline;

//TODO: If we want autonomous this is the class for it
public abstract class Autonomous extends OpenCvPipeline {
    //Camera Sensor
    SensorColor color = new SensorColor();

    //all the motors on the robot
    //DcMotor motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
    //DcMotor motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
   // DcMotor motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
   // DcMotor motorBackRight = hardwareMap.dcMotor.get("motorBackRight");
   // Servo clawServo = hardwareMap.servo.get("clawMotor"); // the servo for the clasw
   // DcMotor liftMotor1 = hardwareMap.dcMotor.get("liftMotor1"); // the motor for the elevator
    //

    public Autonomous(){
      run();
    }
    public void run(){
        color.runOpMode();


        //the code for driving

    }



}
