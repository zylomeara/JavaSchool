package homeworks.lesson_1;

public class BubbleSort {

    public static int[] sort(int[] lst) {
        for(int j = lst.length - 2; j >= 0; j--) {
            for(int i = 0; i <= j; i++) {
                if (lst[i] > lst[i + 1]) {
                    int el = lst[i];
                    lst[i] = lst[i + 1];
                    lst[i + 1] = el;
                }
            }
        }
        return lst;
    }
}
