package homeworks.lesson_1_sort_search_converter;

import org.junit.Test;

public class TestCelsiumConverter {
    @Test
    public void getFahrenheitFromCelsium() {
        CelsiumConverter celsiumConverter = new CelsiumConverter(27);

        assert Float.compare(celsiumConverter.getFahrenheit(), 80.6f) == 0;
    }

    @Test
    public void getKelvinFromCelsium() {
        CelsiumConverter celsiumConverter = new CelsiumConverter(27);

        assert Float.compare(celsiumConverter.getKelvin(), 300.15f) == 0;
    }
}
