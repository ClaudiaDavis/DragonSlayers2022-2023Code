package org.firstinspires.ftc.teamcode;
//THIS IS UNFINISHED

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorColor;

public class Autonomous{
    //Camera Sensor
    SensorColor color = new SensorColor();

    public Autonomous(){
      run();
    }
    public void run(){
        color.runOpMode();
    }



}
