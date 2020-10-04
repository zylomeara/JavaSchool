package homeworks.lesson_9_lambda;

import homeworks.lesson_9_lambda.task_1_my_stream.MyStream;
import org.junit.Test;

public class MyStreamTest {
    @Test
    public void test() {
        MyStream.of(1,1, 2, 3, 4, 4, 5)
                .filter(el -> el % 2 == 0)
                .map(el -> el + 1)
                .distinct()
                .forEach(System.out::println);
    }
}
