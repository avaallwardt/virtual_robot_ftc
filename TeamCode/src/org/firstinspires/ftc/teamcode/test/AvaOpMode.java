package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import javafx.scene.input.KeyCode;

// if push
// overloaded strafe left -- takes in a double (how much power to apply in strafe left)




@TeleOp(name = "avaOpMode")
public class AvaOpMode extends OpMode {

    DcMotor m1, m2, m3, m4;
    double verticalLeftJoystick;
    double horizontalLeftJoystick ;
    boolean manualMode = false;


// motors initialized, right side is reversed
    public void strafeRight(){
        m1.setPower(-1);
        m2.setPower(1);
        m3.setPower(1);
        m4.setPower(-1);
    }
    public void strafeLeft(){
        m1.setPower(1);
        m2.setPower(-1);
        m3.setPower(-1);
        m4.setPower(1);
    }


    @Override
    public void init() {
        m1 = hardwareMap.dcMotor.get("back_right_motor");
        m2 = hardwareMap.dcMotor.get("back_left_motor");
        m3 = hardwareMap.dcMotor.get("front_right_motor");
        m4 = hardwareMap.dcMotor.get("front_left_motor");
        m1.setDirection(DcMotor.Direction.REVERSE);
        m3.setDirection(DcMotor.Direction.REVERSE);

    }

    @Override
    public void loop() {
        verticalLeftJoystick = -1 * gamepad1.left_stick_y;
        horizontalLeftJoystick = gamepad1.left_stick_x;
        telemetry.addData("y-axis value", verticalLeftJoystick);
        telemetry.addData("x-axis value", horizontalLeftJoystick);

        telemetry.addData("back_right_motor", m1.getCurrentPosition());
        telemetry.addData("back_left_motor", m2.getCurrentPosition());
        telemetry.addData("front_right_motor", m3.getCurrentPosition());
        telemetry.addData("front_left_motor", m4.getCurrentPosition());
        telemetry.addData("Manual State:",manualMode);


        telemetry.update();
        if(manualMode == true) {
            m1.setPower(verticalLeftJoystick);
            m2.setPower(verticalLeftJoystick);
        }


        if(gamepad1.start) {
            manualMode = !manualMode;
        }


        if(gamepad1.b){;
            strafeRight();
        }
        if(gamepad1.x){
            strafeLeft();
        }
    }

    // 2 op mode forms: op mode and linear
    /*
    init and loop are 2 required
    init: runs once; loop runs over and over again during game
    init = initial
    1. declare components
    2. in init, initialize it --> link to control hub
        must have class implement an op mode
        implement = borrow method from another class
    mecanum = 4 motors
     */








}
