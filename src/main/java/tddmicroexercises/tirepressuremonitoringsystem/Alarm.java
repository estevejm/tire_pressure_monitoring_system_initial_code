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
        double psiPressureValue = getPsiPressureValue();

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue) {
            alarmOn = true;
        }
    }

    protected double getPsiPressureValue() {
        return pressureSensor.popNextPressurePsiValue();
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }

    public static Alarm withSensor(PressureSensor pressureSensor) {
        return new Alarm(pressureSensor);
    }
}
