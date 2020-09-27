package homeworks.lesson_3_generics.task_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }

    public static <T> List<T> limit(List<? extends T> source, int size) {
        return source.stream().limit(size).collect(Collectors.toList());
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        return !Collections.disjoint(c1, c2);
    }

    public static <T extends Comparable<T>> List<T> range(List<? extends T> list, T min, T max) {
        return list.stream()
                .filter(el ->
                el.compareTo(min) >= 0
                        && el.compareTo(max) <= 0)
                .collect(Collectors.toList());
    }

    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<T> comparator) {
        return list.stream()
                .filter(el -> comparator.compare(el, min) >= 0
                        && comparator.compare(el, max) <= 0)
                .collect(Collectors.toList());
    }
}

