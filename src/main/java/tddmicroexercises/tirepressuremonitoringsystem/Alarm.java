package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    private Sensor sensor;

    private boolean alarmOn = false;

    private Alarm(Sensor sensor) {
        this.sensor = sensor;
    }

    public void check() {
        double psiPressureValue = getNextReading();

        if (isSafe(psiPressureValue)) {
            alarmOn = true;
        }
    }

    private boolean isSafe(double psiPressureValue) {
        return psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue;
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
