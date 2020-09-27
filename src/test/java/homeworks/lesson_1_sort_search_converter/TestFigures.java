package homeworks.lesson_1_sort_search_converter;

import homeworks.lesson_1_sort_search_converter.figures.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestFigures {
    @Test
    public void test() {
        List<Figure> figures = new ArrayList<>();

        figures.add(new Circle(5));
        figures.add(new Rect(5, 10));
        figures.add(new Square(3));
        figures.add(new Triangle(1, 2, 3));

        figures.forEach(figure -> System.out.println(figure.getPerimeter()));
    }
}
