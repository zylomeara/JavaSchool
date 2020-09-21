package homeworks.lesson_5;

import homeworks.lesson_5.beans.Quadrangle;
import homeworks.lesson_5.beans.Triangle;
import org.junit.Test;

public class BeansUtilsTest {
    @Test
    public void test() {
        Triangle triangle = new Triangle(0, 0, 0);
        Quadrangle quadrangle = new Quadrangle(10,  20, 30, 40);

        BeanUtils.assign(triangle, quadrangle);

        System.out.println(triangle);
    }
}
