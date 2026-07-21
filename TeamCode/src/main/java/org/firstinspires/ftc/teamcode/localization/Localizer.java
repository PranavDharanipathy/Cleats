package org.firstinspires.ftc.teamcode.localization;

import org.firstinspires.ftc.teamcode.math.Pose;

public abstract class Localizer {

    protected Pose pose, velocity, acceleration, jerk;

    protected double deltaTime;

    public Localizer() {

        pose = new Pose(0,0,0);
        velocity = new Pose(0,0,0);
        acceleration = new Pose(0,0,0);
        jerk = new Pose(0,0,0);

        deltaTime = 0;
    }

    public abstract void setPose(Pose pose);

    public abstract void update();

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

    /// @return time between localizer updates in seconds.
    public double getDeltaTime() {
        return deltaTime;
    }

}