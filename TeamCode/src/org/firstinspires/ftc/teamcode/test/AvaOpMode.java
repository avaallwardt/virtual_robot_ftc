package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import javafx.scene.input.KeyCode;

// if push
// overloaded strafe left -- takes in a double (how much power to apply in strafe left)
// get the value fron the joystick




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
    public void strafeRight(double power) {
        m1.setPower(-1 * power);
        m2.setPower(power);
        m3.setPower(power);
        m4.setPower(-1 * power);
    }
    public void stop(){
        m1.setPower(0);
        m2.setPower(0);
        m3.setPower(0);
        m4.setPower(0);
    }

    // intake motor methods
    public void intake(){
        m1.setPower(1);
        m2.setPower(1);
    }
    public void intakeOpposite(){
        m1.setPower(-1);
        m2.setPower(-1);
    }
    public void output(){
        m1.setPower(-1);
        m2.setPower(-1);
    }
    public void outputOpposite(){
        m1.setPower(1);
        m2.setPower(1);
    }



        @Override
    public void init() {
        m1 = hardwareMap.dcMotor.get("back_right_motor");
     //   m2 = hardwareMap.dcMotor.get("back_left_motor");
     //   m3 = hardwareMap.dcMotor.get("front_right_motor");
     //   m4 = hardwareMap.dcMotor.get("front_left_motor");
            //   m1.setDirection(DcMotor.Direction.REVERSE);
       // m3.setDirection(DcMotor.Direction.REVERSE);

    }

    @Override
    public void loop() {
        if(gamepad1.b){
            intake();
        }
        if(gamepad1.a){
            output();
        }



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


    if(horizontalLeftJoystick > 0){
        strafeRight(horizontalLeftJoystick);
    }

    if(horizontalLeftJoystick == 0) {

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
