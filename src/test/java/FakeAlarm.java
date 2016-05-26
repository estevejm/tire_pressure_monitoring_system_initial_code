import tddmicroexercises.tirepressuremonitoringsystem.Alarm;

public class FakeAlarm extends Alarm {

    private int value;

    private FakeAlarm(int value) {
        this.value = value;
    }

    @Override
    protected double getPsiPressureValue() {
        return this.value;
    }

    public static FakeAlarm reading(int value) {
        return new FakeAlarm(value);
    }
}
