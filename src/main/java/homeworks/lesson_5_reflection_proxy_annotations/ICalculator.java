package homeworks.lesson_5_reflection_proxy_annotations;

import homeworks.lesson_5_reflection_proxy_annotations.annotations.Cache;
import homeworks.lesson_5_reflection_proxy_annotations.annotations.Metric;

public interface ICalculator {
    /**
     * Расчет факториала числа. * @param number
     */
    @Metric
    @Cache
    int calc (int number);
}
