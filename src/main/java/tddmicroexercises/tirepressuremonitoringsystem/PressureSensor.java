package tddmicroexercises.tirepressuremonitoringsystem;

import java.util.Random;

public class PressureSensor {
    public static final double OFFSET = 16;

    public double popNextPressurePsiValue() {
        return OFFSET + samplePressure();
    }

    private static double samplePressure() {
        // placeholder implementation that simulate a real sensor in a real tire
        Random basicRandomNumbersGenerator = new Random();
        double pressureTelemetryValue = 6 * basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble();
        return pressureTelemetryValue;
    }
}
