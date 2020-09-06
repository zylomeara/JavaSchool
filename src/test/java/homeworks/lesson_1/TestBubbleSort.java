package homeworks.lesson_1;

import org.junit.Test;

import java.util.Arrays;

public class TestBubbleSort {
    @Test
    public void testArrayWithDuplicates() {
        int[] realArray = { 5, 3, 3, 2, 2, 4, 1 };
        int[] expectedArray = { 1, 2, 2, 3, 3, 4, 5 };

        BubbleSort.sort(realArray);

        assert Arrays.equals(realArray, expectedArray);
    }

    @Test
    public void testEmptyArray() {
        int[] realArray = {  };
        int[] expectedArray = {  };

        BubbleSort.sort(realArray);

        assert Arrays.equals(realArray, expectedArray);
    }
}
