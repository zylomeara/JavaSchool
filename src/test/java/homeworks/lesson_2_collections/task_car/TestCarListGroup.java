package homeworks.lesson_2_collections.task_car;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCarListGroup {

    @Test
    public void test() {
        Car[] cars = {
                new Car("Лада", CarType.SEDAN),
                new Car("Лада", CarType.HATCHBACK),
                new Car("Мерседес", CarType.SEDAN),
                new Car("Бмв", CarType.CROSSOVER),
                new Car("Форд", CarType.HATCHBACK),
                new Car("Пежо", CarType.CROSSOVER),
                new Car("Тойота", CarType.SEDAN),
        };

        Map<CarType, List<Car>> carsByType = Stream.of(cars)
                .collect(Collectors.groupingBy(Car::getType));

        carsByType.entrySet()
                .forEach((entry -> System.out.println(entry.getKey().getTypeName() + ": " + entry.getValue())));
    }
}
