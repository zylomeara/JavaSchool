package homeworks.lesson_1_sort_search_converter;

import java.util.Optional;

public class BinarySearch {
    public static Optional<Integer> search(int[] lst, int searchElement) {
        int left = 0;
        int right = lst.length - 1;
        while(left <= right) {
            int midIndex = left + (right - left) / 2;
            if (lst[midIndex] == searchElement) {
                return Optional.of(midIndex);
            } else if (lst[midIndex] > searchElement) {
                right = midIndex - 1;
            } else {
                left = midIndex + 1;
            }
        }

        return Optional.empty();
    }
}
