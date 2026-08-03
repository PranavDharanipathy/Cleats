package org.firstinspires.ftc.teamcode.localization;

public class OdometryPod {

    private OdometryPod(double inchesPerTick) {
        this.inchesPerTick = inchesPerTick;
    }

    private final double inchesPerTick;

    public static OdometryPod createCustomPod(double ticksPerRevolution, double wheelDiameterInches) {
        return new OdometryPod(Math.PI * (wheelDiameterInches / ticksPerRevolution));
    }

    public static OdometryPod createGobildaSwingArmPod() {
        return new OdometryPod(0.0029684340033919307);
    }

    public static OdometryPod createGobildaFourBarPod() {
        return new OdometryPod(0.0019789560022612871);
    }

    public static OdometryPod createSwyftLinearPod() {
        return new OdometryPod(0.0011474659436939835);
    }

    public double getInchesPerTick() {
        return inchesPerTick;
    }
}
