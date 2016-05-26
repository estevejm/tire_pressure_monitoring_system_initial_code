import tddmicroexercises.tirepressuremonitoringsystem.Alarm;

import java.util.ArrayList;
import java.util.List;

public class FakeAlarm extends Alarm {

    private final List<Integer> readings;
    private int index;

    private FakeAlarm(List<Integer> readings) {
        this.index = 0;
        this.readings = readings;
    }

    @Override
    protected double getPsiPressureValue() {
        int value = readings.get(index);
        index++;
        return value;
    }

    public static FakeAlarm reading(int value) {
        List<Integer> readings = new ArrayList<Integer>();
        readings.add(value);

        return new FakeAlarm(readings);
    }

    public static FakeAlarm reading(List<Integer> readings) {
        return new FakeAlarm(readings);
    }
}

