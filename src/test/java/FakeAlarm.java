import tddmicroexercises.tirepressuremonitoringsystem.Alarm;

// todo: change name to failing fake alarm or similar
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
