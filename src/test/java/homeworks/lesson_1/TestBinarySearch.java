package homeworks.lesson_1;

import org.junit.Test;

import java.util.Optional;

public class TestBinarySearch {
    int[] realArray = { 1, 2, 3, 4, 5, 6 };

    @Test
    public void testSearchWithNotExistsElement() {
        Optional<Integer> element = BinarySearch.search(realArray, 7);

        assert !element.isPresent();
    }

    @Test
    public void testSearchWithExistsElement() {
        Optional<Integer> element = BinarySearch.search(realArray, 3);

        assert element.orElse(-1) == 2;
    }

    @Test
    public void testSearchFirstElement() {
        Optional<Integer> element = BinarySearch.search(realArray, 1);

        assert element.orElse(-1) == 0;
    }

    @Test
    public void testSearchLastElement() {
        Optional<Integer> element = BinarySearch.search(realArray, 6);

        assert element.orElse(-1) == 5;
    }

    @Test
    public void testSearchElementInEmptyArray() {
        int[] emptyArray = { };

        Optional<Integer> element = BinarySearch.search(emptyArray, 6);

        assert !element.isPresent();
    }
}
