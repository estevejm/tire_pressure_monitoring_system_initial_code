import org.junit.Test;
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
}
