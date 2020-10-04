package homeworks.lesson_9_lambda.task_3_tribonacci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Tribonacci {
    public static List<Integer> tribonacciList(int size) {
        ArrayGetter<Integer> tryGetter = (list, index) -> {
            try {
                return Optional.of(list.get(index));
            } catch (IndexOutOfBoundsException e) {
                return Optional.empty();
            }
        };

        List<Integer> list = Stream
                .iterate(1, i -> i + 1)
                .limit(size < 4 ? 0 : size)
                .reduce(
                        new ArrayList<>(Arrays.asList(0, 0, 1)),
                        (acc, next) -> {
                            int currentIndex = acc.size();
                            int n1 = tryGetter.tryGet(acc, currentIndex - 1).orElse(0);
                            int n2 = tryGetter.tryGet(acc, currentIndex - 2).orElse(0);
                            int n3 = tryGetter.tryGet(acc, currentIndex - 3).orElse(0);
                            int currentEl = n1 + n2 + n3;

                            acc.add(currentEl);
                            return acc;
                        },
                        (a, b) -> {
                            a.addAll(b);
                            return a;
                        })
                .subList(0, size);

        return list;
    }

    public static int getTribonacciItem(int n) {
        assert n > 0 : "Введите число от 1 до n";

        List<Integer> tribonacciList = tribonacciList(n);

        return tribonacciList.get(n - 1);
    }
}
