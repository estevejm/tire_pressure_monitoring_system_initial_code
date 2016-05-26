import org.junit.Test;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.SafetyRange;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AlarmTest {

    @Test
    public void alarm_is_on_when_pressure_is_too_low() {
        FakeSensor sensor = FakeSensor.reading(10);
        Alarm alarm = Alarm.withSensorAndSafetyRange(sensor, new SafetyRange(15, 25));

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void alarm_is_off_when_pressure_is_normal() {
        FakeSensor sensor = FakeSensor.reading(20);
        Alarm alarm = Alarm.withSensorAndSafetyRange(sensor, new SafetyRange(15, 25));

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(false));
    }

    @Test
    public void alarm_is_on_when_pressure_is_too_high() {
        FakeSensor sensor = FakeSensor.reading(30);
        Alarm alarm = Alarm.withSensorAndSafetyRange(sensor, new SafetyRange(15, 25));

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void alarm_remain_on_after_pressure_is_normal_again() {
        List<Integer> readings = new ArrayList<Integer>();
        readings.add(10);
        readings.add(20);

        AlarmBuilder builder = new AlarmBuilder();

        builder.withSensor(FakeSensor.reading(readings));
        builder.withSafetyRange(new SafetyRange(15, 25));

        Alarm alarm = builder.build();

        alarm.check();
        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }
}
