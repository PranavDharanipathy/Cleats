package org.firstinspires.ftc.teamcode.math;

public class LowPassFilter {

    public static double getFilteredValue(double prevFiltered, double currRaw, double alpha) {
        return (1 - alpha) * prevFiltered + (alpha * currRaw);
    }
}
