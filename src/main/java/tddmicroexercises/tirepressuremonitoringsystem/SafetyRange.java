package tddmicroexercises.tirepressuremonitoringsystem;

public class SafetyRange {
    private final int lowThreshold;
    private final int highThreshold;

    public SafetyRange(int lowThreshold, int highThreshold) {
        this.lowThreshold = lowThreshold;
        this.highThreshold = highThreshold;
    }

    public boolean isSafe(double reading) {
        return reading < this.lowThreshold || this.highThreshold < reading;
    }
}
