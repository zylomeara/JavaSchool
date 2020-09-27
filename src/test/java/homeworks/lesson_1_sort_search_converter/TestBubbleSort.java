package homeworks.lesson_1_sort_search_converter;

import org.junit.Test;

import java.util.Arrays;

public class TestBubbleSort {
    @Test
    public void testArrayWithDuplicates() {
        Integer[] realArray = { 5, 3, 3, 2, 2, 4, 1 };
        Integer[] expectedArray = { 1, 2, 2, 3, 3, 4, 5 };

        BubbleSort.sort(realArray);

        assert Arrays.equals(realArray, expectedArray);
    }

    @Test
    public void testEmptyArray() {
        Integer[] realArray = {  };
        Integer[] expectedArray = {  };

        BubbleSort.sort(realArray);

        assert Arrays.equals(realArray, expectedArray);
    }
}
