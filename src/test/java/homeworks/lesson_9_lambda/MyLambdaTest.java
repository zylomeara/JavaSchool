package homeworks.lesson_9_lambda;

import homeworks.lesson_9_lambda.task_2_my_lambda.MyLambda;
import homeworks.lesson_9_lambda.task_3_tribonacci.Tribonacci;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MyLambdaTest {
    @Test
    public void lambdaSumTest() {
        MyLambda<Integer> sumIntFn = Integer::sum;
        MyLambda<String> sumStrFn = String::concat;

        assertEquals(3, (int) sumIntFn.sum(1, 2));
        assertEquals("Hello World", sumStrFn.sum("Hello ", "World"));
    }


    @Test
    public void tribonacciListTest() {
        List<Integer> expectList = Arrays.asList(0, 0, 1, 1, 2, 4, 7, 13, 24);
        List<Integer> realList = Tribonacci.tribonacciList(9);

        assertEquals(expectList, realList);
    }

    @Test
    public void tribonacciItemTest() {
        assertEquals(24, Tribonacci.getTribonacciItem(9));
    }
}
