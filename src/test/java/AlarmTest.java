import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AlarmTest {
    @Test
    public void alarm_is_on_when_pressure_is_too_low() {
        FakeAlarm alarm = new FakeAlarm();

        alarm.check();

        assertThat(alarm.isAlarmOn(), is(true));
    }
}
