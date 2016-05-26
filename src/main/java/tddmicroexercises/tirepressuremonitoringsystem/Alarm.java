package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    private Sensor sensor;
    private final SafetyRange safetyRange;

    private boolean alarmOn = false;

    public Alarm(Sensor sensor, SafetyRange safetyRange) {
        this.sensor = sensor;
        this.safetyRange = safetyRange;
    }

    public void check() {
        double reading = getNextReading();

        if (isSafe(reading)) {
            alarmOn = true;
        }
    }

    private boolean isSafe(double reading) {
        return this.safetyRange.isSafe(reading);
    }

    protected double getNextReading() {
        return sensor.read();
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }

    public static Alarm withSensorAndSafetyRange(Sensor sensor, SafetyRange safetyRange) {
        return new Alarm(sensor, safetyRange);
    }

    public static Alarm withDefaultSensorAndSafetyRange() {
        return new Alarm(new PressureSensor(), new SafetyRange(17, 21));
    }
}
