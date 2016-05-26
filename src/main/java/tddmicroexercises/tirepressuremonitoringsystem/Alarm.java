package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    private PressureSensor pressureSensor;

    private boolean alarmOn = false;

    public Alarm() {
        this(new PressureSensor());
    }

    private Alarm(PressureSensor pressureSensor) {
        this.pressureSensor = pressureSensor;
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
        return pressureSensor.popNextPressurePsiValue();
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }

    public static Alarm withSensor(PressureSensor pressureSensor) {
        return new Alarm(pressureSensor);
    }
}
