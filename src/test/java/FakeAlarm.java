import tddmicroexercises.tirepressuremonitoringsystem.Alarm;

// todo: change name to failing fake alarm or similar
public class FakeAlarm extends Alarm {

    @Override
    protected double getPsiPressureValue() {
        return 10;
    }
}
