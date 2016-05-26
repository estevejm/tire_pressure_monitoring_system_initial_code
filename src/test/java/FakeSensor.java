import tddmicroexercises.tirepressuremonitoringsystem.PressureSensor;

import java.util.ArrayList;
import java.util.List;

public class FakeSensor extends PressureSensor {

    private final List<Integer> readings;
    private int index;

    private FakeSensor(List<Integer> readings) {
        this.index = 0;
        this.readings = readings;
    }

    @Override
    public double read() {
        int value = readings.get(index);
        index++;

        return value;
    }

    public static FakeSensor reading(int value) {
        List<Integer> readings = new ArrayList<Integer>();
        readings.add(value);

        return new FakeSensor(readings);
    }

    public static FakeSensor reading(List<Integer> readings) {
        return new FakeSensor(readings);
    }
}
