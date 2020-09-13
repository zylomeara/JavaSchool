package homeworks.lesson_3.task_1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class TestCountMap {
    @Test
    public void testAddElements() {
        CountMap<Integer> integerCountMap = new CountMap<>();

        Stream.of(1, 2, 2, 3)
                .forEach(integerCountMap::add);

        assert integerCountMap.getCount(1) == 1
                && integerCountMap.getCount(2) == 2
                && integerCountMap.getCount(3) == 1
                && integerCountMap.size() == 4;
    }

    @Test
    public void testRemoveElements() {
        CountMap<Integer> integerCountMap = new CountMap<>();

        Stream.of(1, 2, 2, 3)
                .forEach(integerCountMap::add);
        integerCountMap.remove(1);
        integerCountMap.remove(2);

        assert integerCountMap.getCount(1) == 0
                && integerCountMap.getCount(2) == 0;
    }

    @Test
    public void testGetCountElements() {
        CountMap<Integer> integerCountMap = new CountMap<>();

        Stream.of(1, 2, 2, 3)
                .forEach(integerCountMap::add);
        int count = integerCountMap.getCount(2);

        assert count == 2;
    }

    @Test
    public void testGetCountAllElements() {
        CountMap<Integer> integerCountMap = new CountMap<>();

        Stream.of(1, 2, 2, 3)
                .forEach(integerCountMap::add);

        assert integerCountMap.size() == 4;
    }

    @Test
    public void testAddAllElements() {
        CountMap<Integer> firstCountMap = new CountMap<>();
        CountMap<Integer> secondCountMap = new CountMap<>();

        Stream.of(1, 2, 2, 3)
                .forEach(firstCountMap::add);
        secondCountMap.addAll(firstCountMap);

        assert firstCountMap.equals(secondCountMap);
    }

    @Test
    public void testCountMapToMap() {
        CountMap<Integer> countMap = new CountMap<>();
        Map<Integer, Integer> map = new HashMap<>();

        Stream.of(1, 2, 2, 3)
                .forEach(countMap::add);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 1);

        assert countMap.toMap().equals(map);
    }

    @Test
    public void testExtractDataFromCountMap() {
        CountMap<Integer> countMap = new CountMap<>();
        Map<Integer, Integer> map = new HashMap<>();

        Stream.of(1, 2, 2, 3)
                .forEach(countMap::add);
        countMap.toMap(map);

        assert countMap.toMap().equals(map);
    }
}
