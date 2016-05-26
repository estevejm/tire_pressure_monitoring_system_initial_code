package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    private final double LowThreshold = 17;
    private final double HighThreshold = 21;

    private Sensor sensor;

    private boolean alarmOn = false;

    private Alarm(Sensor sensor) {
        this.sensor = sensor;
    }

    public void check() {
        double reading = getNextReading();

        if (isSafe(reading)) {
            alarmOn = true;
        }
    }

    private boolean isSafe(double reading) {
        return reading < LowThreshold || HighThreshold < reading;
    }

    protected double getNextReading() {
        return sensor.read();
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }

    public static Alarm withSensor(Sensor sensor) {
        return new Alarm(sensor);
    }

    public static Alarm withDefaultSensor() {
        return new Alarm(new PressureSensor());
    }
}
