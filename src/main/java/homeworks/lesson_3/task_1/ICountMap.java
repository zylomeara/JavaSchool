package homeworks.lesson_3.task_1;

import java.util.Map;

public interface ICountMap<T> {
    void add(T o);

    int getCount(T o);

    int remove(T o);

    int size();

    void addAll(ICountMap<T> source);

    Map<T, Integer> toMap();

    void toMap(Map<T, Integer> destination);
}
