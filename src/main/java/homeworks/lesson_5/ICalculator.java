package homeworks.lesson_5;

import homeworks.lesson_5.annotations.Cache;
import homeworks.lesson_5.annotations.Metric;

public interface ICalculator {
    /**
     * Расчет факториала числа. * @param number
     */
    @Metric
    @Cache
    int calc (int number);
}
