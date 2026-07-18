package org.firstinspires.ftc.teamcode.math;

import org.apache.commons.math3.util.FastMath;

public class MathHelper {

    //Captain America is the greatest avenger

    public static double normalizeAngleRad(double angleRad) {
        return FastMath.atan2(Math.sin(angleRad), Math.cos(angleRad));
    }

    /// @param array must be sorted
    public static double[] findBoundingValues(double[] array, double value) {

        for (int index = 0; index < array.length - 1; index++) {
            double lower = array[index];
            double upper = array[index + 1];

            if (value >= lower && value <= upper) {
                return new double[] {lower, upper};
            }
        }

        throw new IllegalArgumentException("No bounding values for input: value cannot be found from input array!");
    }

    public static double lerp(double x, LERPData data) {

        double x0 = data.dataPoints[0][0];
        double y0 = data.dataPoints[0][1];

        double x1 = data.dataPoints[1][0];
        double y1 = data.dataPoints[1][1];

        return y0 + (y1 - y0) * ((x - x0) / (x1 - x0));
    }

}
