/*
Copyright 2026 FIRST Tech Challenge Team FTC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
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
    
    double intakespeed = 0;



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
                intakespeed = 2000;
            }
            else{
                intakespeed=0;
            }
            
            //Sett the motors strength to the flyspeed
            fly1.setPower(flyspeed1);
            fly2.setPower(flyspeed2);
            
            // Add data to the screen
            telemetry.addData("Status", "Running");
            telemetry.addData("velocity1", flyspeed1);
            telemetry.addData("velocity2", flyspeed2);
            telemetry.update();

        }
    }
}
