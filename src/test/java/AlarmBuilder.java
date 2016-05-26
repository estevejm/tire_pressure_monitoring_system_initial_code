import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.SafetyRange;

public class AlarmBuilder {
    private FakeSensor sensor;
    private SafetyRange safetyRange;

    public void withSensor(FakeSensor sensor) {

        this.sensor = sensor;
    }

    public void withSafetyRange(SafetyRange safetyRange) {

        this.safetyRange = safetyRange;
    }

    public Alarm build() {
        return Alarm.withSensorAndSafetyRange(sensor, safetyRange);
    }
}
