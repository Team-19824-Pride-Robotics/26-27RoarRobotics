package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous

public class SimpleAuto2 extends LinearOpMode {


    private DcMotor left;
    private DcMotor right;
    private ElapsedTime timer = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        // Initialize the hardware variables.

        DcMotor left = hardwareMap.get(DcMotor.class, "left");
        DcMotor right = hardwareMap.get(DcMotor.class, "right");

        waitForStart();


        timer.reset();


        while (timer.seconds() < 1 ) {

            left.setPower(1);
            right.setPower(1);
        }
        left.setPower(0);
        right.setPower(0);


    }

}

