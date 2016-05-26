import org.junit.Test;
import tddmicroexercises.tirepressuremonitoringsystem.Alarm;
import tddmicroexercises.tirepressuremonitoringsystem.SafetyRange;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AlarmTest {

    AlarmBuilder builder = new AlarmBuilder();

    @Test
    public void alarm_is_on_when_pressure_is_too_low() {
        Alarm alarm = builder
            .withSensor(FakeSensor.reading(10))
            .withSafetyRange(new SafetyRange(15, 25))
            .build();

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void alarm_is_off_when_pressure_is_normal() {
        Alarm alarm = builder
            .withSensor(FakeSensor.reading(20))
            .withSafetyRange(new SafetyRange(15, 25))
            .build();

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(false));
    }

    @Test
    public void alarm_is_on_when_pressure_is_too_high() {
        Alarm alarm = builder
            .withSensor(FakeSensor.reading(30))
            .withSafetyRange(new SafetyRange(15, 25))
            .build();

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void alarm_remain_on_after_pressure_is_normal_again() {
        List<Integer> readings = new ArrayList<Integer>();
        readings.add(10);
        readings.add(20);

        Alarm alarm = builder
            .withSensor(FakeSensor.reading(readings))
            .withSafetyRange(new SafetyRange(15, 25))
            .build();

        alarm.check();
        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }
}
