package tddmicroexercises.tirepressuremonitoringsystem;

import java.util.Random;

public class PressureSensor implements Sensor {
    public static final double OFFSET = 16;

    public double read() {
        return this.popNextPressurePsiValue();
    }

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
