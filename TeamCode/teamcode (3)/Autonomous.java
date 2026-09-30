import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class Autonomous extends LinearOpMode {
    //Define variables
    private ElapsedTime runtime = new ElapsedTime(); //Runtime var
    private wheelMotor  = null;


    double wheelSpeed = 20000
   @Override
   public void runOpMode() {
        // Define wheel motor in hardware
        wheelMotor = hardwareMap.get(DcMotor.class, "WheelMotor")


        //Reset Wheel motor
       wheelMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       wheelMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

       waitForStart();
       runtime.reset(); //reset runtime

       while (opModeIsActive() && runtime.seconds() <30.0){ //Run for 30 seconds
           wheelMotor = wheelSpeed;
       }
   }



}