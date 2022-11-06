package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Encoder {

    public static double findTicksPerMM(DcMotor motor, double wheelDiameter){ //diameter must be in mm
        double ticksPerRev = motor.getMotorType().getTicksPerRev();
        double circumference = wheelDiameter * Math.PI;
        return ticksPerRev / circumference; // returns ticks per mm
    }

    public static double ticksNeededForward(DcMotor motor, boolean motorIsForward, double wheelDiameter, double distance, boolean trueIfMM){ // diameter must be in mm, distance can be mm or ft
        if(trueIfMM == false){
            // if the distance was given in feet, it converts it from ft to mm
            distance = distance * 304.8; // converts distance from ft to mm
        }
        double numTicksNeeded = findTicksPerMM(motor, wheelDiameter) * distance;
        if(motorIsForward){
            return numTicksNeeded;
        }
        else{
            return numTicksNeeded * -1;
        }
        // returns a positive tick value if the motor is oriented correctly (where positive is forward). returns a negative tick value if the motor is backward (where positive returns backward)
    }
    public static double ticksNeededBackward(DcMotor motor, boolean motorIsForward, double wheelDiameter, double distance, boolean trueIfMM) { // diameter must be in mm, distance can be mm or ft
        if (trueIfMM == false) {
            // if the distance was given in feet, it converts it from ft to mm
            distance = distance * 304.8; // converts distance from ft to mm
        }
        double numTicksNeeded = findTicksPerMM(motor, wheelDiameter) * distance;
        if (motorIsForward) {
            // if the motor is oriented correctly, a negative tick value will move it backward
            return numTicksNeeded * -1;
        } else {
            // if the motor is oriented backward, a positive tick value will move it backward
            return numTicksNeeded;
        }

    }


}
