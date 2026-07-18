package org.firstinspires.ftc.teamcode.following;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/// Mecanum drivetrain
public class Chassis {

    private final DcMotor lf, rf, lb, rb;

    /// @param motorDeviceNames should contain the names in the order of left front, right front, left back, right back.
    /// @param motorDirections should contain the names in the order of left front, right front, left back, right back.
    public Chassis(HardwareMap hardwareMap, String[] motorDeviceNames, DcMotorSimple.Direction[] motorDirections) {

        lf = hardwareMap.get(DcMotor.class, motorDeviceNames[0]);
        rf = hardwareMap.get(DcMotor.class, motorDeviceNames[1]);
        lb = hardwareMap.get(DcMotor.class, motorDeviceNames[2]);
        rb = hardwareMap.get(DcMotor.class, motorDeviceNames[3]);

        lf.setDirection(motorDirections[0]);
        rf.setDirection(motorDirections[1]);
        lb.setDirection(motorDirections[2]);
        rb.setDirection(motorDirections[3]);
    }

    public void setDrivePower(double forward, double strafe, double turn) {

        lf.setPower(forward - strafe - turn);
        rf.setPower(forward + strafe + turn);
        lb.setPower(forward + strafe - turn);
        rb.setPower(forward - strafe + turn);
    }
}
