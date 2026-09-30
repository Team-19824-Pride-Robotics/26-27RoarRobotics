
package org.firstinspires.ftc.teamcode;
//Import packages
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp

public class ShooterSt extends LinearOpMode {
    //Declare varables 
    private DcMotor fly1 = null; 
    private DcMotor fly2 = null; 
    private DcMotor intakeMotor = null;
    
    public double lanchingpower = 2000;//Speed of outake
    double flyspeed1 = 0;
    double flyspeed2 = 0;
    
    double intakespeed = 2000; //Intake speed



    @Override
    public void runOpMode() {
        // Congiguring motor's
        fly1 = hardwareMap.get(DcMotor.class, "fly1"); //changes by flyspeed1 
        fly2 = hardwareMap.get(DcMotor.class, "fly2"); //changes by flyspeed2
        
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        
        fly1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); //Reset encoder
        fly1.setMode(DcMotor.RunMode.RUN_USING_ENCODER); 
        
        
        fly2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); //Reset encoder
        fly2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        intakeMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeMotot.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
        
            //Move if the right trigger is being held
            if (gamepad1.right_trigger > .1 ) {
                
                flyspeed1=lanchingpower;
                flyspeed2=lanchingpower;
                
            }
            else {
                
                flyspeed1=0;
                flyspeed2=0;
                
            }

            //Intake if a is pressed
            if(gamepad1.aWasPressed(true)) {
                intakeMotor=intakespeed;
            }
            elif(gamepad1.aWasReleased(true)){
                intakespeed=0;
            }
            
            //Set the motors strength to the flyspeed
            fly1.setPower(flyspeed1);
            fly2.setPower(flyspeed2);
            
            // Add data to the screen
            telemetry.addData("Status", "Running");
            telemetry.addData("velocity1: ", flyspeed1);
            telemetry.addData("velocity2: ", flyspeed2);
            telemetry.addData("Intake motor: ", intakespeed);
            telemetry.update();

        }
    }
}