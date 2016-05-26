import tddmicroexercises.tirepressuremonitoringsystem.Alarm;

public class FakeAlarm extends Alarm {

    @Override
    protected double getPsiPressureValue() {
        return 10;
    }
}
