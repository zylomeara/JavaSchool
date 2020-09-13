package homeworks.lesson_3.task_1;

import java.util.HashMap;
import java.util.Map;

public class CountMap<T> implements ICountMap<T> {
    private final Map<T, Integer> destination = new HashMap<>();

    @Override
    public void add(T element) {
        destination.put(element, getCount(element) + 1);
    }

    @Override
    public int getCount(T element) {
        return destination.getOrDefault(element, 0);
    }

    @Override
    public int remove(T element) {
        int count = getCount(element);
        destination.remove(element);

        return count;
    }

    @Override
    public int size() {
        return destination.values().stream()
                .reduce(Integer::sum)
                .orElse(0);
    }

    @Override
    public void addAll(ICountMap<T> source) {
        source.toMap()
                .forEach((element, count) -> destination.put(element, getCount(element) + count));
    }

    @Override
    public Map<T, Integer> toMap() {
        return destination;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        destination.putAll(this.destination);
    }

    @Override
    public String toString() {
        return destination.toString();
    }

    public boolean equals (CountMap<T> countMap) {
        return countMap.toMap().equals(destination);
    }
}
