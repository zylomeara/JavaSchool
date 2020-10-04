package homeworks.lesson_9_lambda.task_3_tribonacci;

import java.util.List;
import java.util.Optional;

public interface ArrayGetter<T> {
    Optional<T> tryGet(List<T> list, int el);
}
