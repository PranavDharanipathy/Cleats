package org.firstinspires.ftc.teamcode.localization;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.math.Pose;

/// Uses goBILDA Pinpoint
public class Localizer {
    private final GoBildaPinpointDriver localizer;

    private Pose pose, velocity, acceleration, jerk;

    public Localizer(HardwareMap hardwareMap, PinpointAttributes lAttributes) {

        localizer = hardwareMap.get(GoBildaPinpointDriver.class, lAttributes.getDeviceName());

        localizer.setOffsets(lAttributes.getForwardPodOffset(), lAttributes.getStrafePodOffset(), DistanceUnit.MM);
        localizer.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        localizer.setEncoderDirections(lAttributes.getForwardPodDirection(), lAttributes.getStrafePodDirection());
        localizer.resetPosAndIMU();

        localizer.setPosition(new Pose2D(DistanceUnit.INCH, 0,0, AngleUnit.RADIANS, 0));
        pose = new Pose(0,0,0);
        velocity = new Pose(0,0,0);
        acceleration = new Pose(0,0,0);
        jerk = new Pose(0,0,0);

        currTime = 0;
        startTime = System.nanoTime() * 1e-9;
    }

    private double prevTime, currTime, startTime, dt;

    /// @return time between localizer {@link GoBildaPinpointDriver#update()} calls in seconds.
    public double getDeltaTime() {
        return dt;
    }

    public void setPose(Pose pose) {

        localizer.setPosition(Pose.poseToPose2D(pose));
        this.pose = pose;
    }

    public Pose getPose() {
        return pose;
    }

    public Pose getVelocity() {
        return velocity;
    }

    public Pose getAcceleration() {
        return acceleration;
    }

    public Pose getJerk() {
        return jerk;
    }

    public void update() {

        localizer.update();
        pose = Pose.pose2DToPose(localizer.getPosition());

        prevTime = currTime;
        currTime = (System.nanoTime() * 1e-9) - startTime;
        dt = currTime - prevTime;

        if (dt <= 0) return;

        Pose newVelocity = new Pose(localizer.getVelX(DistanceUnit.INCH), localizer.getVelY(DistanceUnit.INCH), localizer.getHeadingVelocity(AngleUnit.RADIANS.getUnnormalized()));
        Pose newAcceleration = newVelocity.minus(velocity).divideBy(dt);

        jerk = newAcceleration.minus(acceleration).divideBy(dt);

        acceleration = newAcceleration;

        velocity = newVelocity;
    }



}