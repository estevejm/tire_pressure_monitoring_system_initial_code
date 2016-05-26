import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.SafetyRange;

public class AlarmBuilder {
    private FakeSensor sensor;
    private SafetyRange safetyRange;

    public AlarmBuilder withSensor(FakeSensor sensor) {

        this.sensor = sensor;

        return this;
    }

    public AlarmBuilder withSafetyRange(SafetyRange safetyRange) {

        this.safetyRange = safetyRange;

        return this;
    }

    public Alarm build() {
        return Alarm.withSensorAndSafetyRange(sensor, safetyRange);
    }
}
