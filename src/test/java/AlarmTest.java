import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AlarmTest {

    @Test
    public void alarm_is_on_when_pressure_is_too_low() {
        FakeAlarm alarm = FakeAlarm.reading(10);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void alarm_is_off_when_pressure_is_normal() {
        FakeAlarm alarm = FakeAlarm.reading(20);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(false));
    }

    @Test
    public void alarm_is_on_when_pressure_is_too_high() {
        FakeAlarm alarm = FakeAlarm.reading(30);

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }

    @Test
    public void alarm_remain_on_after_pressure_is_normal_again() {
        List<Integer> readings = new ArrayList<Integer>();
        readings.add(10);
        readings.add(20);

        FakeAlarm alarm = FakeAlarm.reading(readings);

        alarm.check();
        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }
}
