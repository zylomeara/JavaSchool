package homeworks.lesson_1_sort_search_converter;

public class BubbleSort {

    public static <T extends Comparable<T>> T[] sort(T[] lst) {
        for(int j = lst.length - 2; j >= 0; j--) {
            for(int i = 0; i <= j; i++) {
                if (lst[i].compareTo(lst[i + 1]) > 0) {
                    T el = lst[i];
                    lst[i] = lst[i + 1];
                    lst[i + 1] = el;
                }
            }
        }
        return lst;
    }
}
