import tddmicroexercises.tirepressuremonitoringsystem.Alarm;

public class NormalFakeAlarm extends Alarm {

    @Override
    protected double getPsiPressureValue() {
        return 20;
    }
}
