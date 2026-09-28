package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name = "Odometry Pod Test", group = "Test")
public class odometry extends LinearOpMode {

    // Define the encoder
    private DcMotorEx odoEncoder;

    // goBILDA Odometry Pod Constant: 2000 Ticks per Revolution
    // Wheel Diameter: 48mm
    static final double TICKS_PER_REV = 2000;
    static final double WHEEL_DIAMETER_MM = 48.0;
    static final double DISTANCE_PER_TICK = (WHEEL_DIAMETER_MM * Math.PI) / TICKS_PER_REV;

    @Override
    public void runOpMode() {
        // Initialize the hardware
        // "odo_pod" must match the name in your Driver Hub Configuration
        odoEncoder = hardwareMap.get(DcMotorEx.class, "odo_pod");

        // Reset the encoder to zero at the start
        odoEncoder.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        odoEncoder.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addLine("Status: Initialized");
        telemetry.addLine("Push the robot forward to test distance.");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            // Get current position in ticks
            int currentTicks = odoEncoder.getCurrentPosition();

            // Calculate distance
            double distanceMm = currentTicks * DISTANCE_PER_TICK;
            double distanceInches = distanceMm / 25.4;

            // Telemetry Output
            telemetry.addData("Encoder Ticks", currentTicks);
            telemetry.addData("Distance (in)", "%.2f", distanceInches);
            telemetry.update();
        }
    }
}