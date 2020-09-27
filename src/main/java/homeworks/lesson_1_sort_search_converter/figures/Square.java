package homeworks.lesson_1_sort_search_converter.figures;

public class Square extends Figure {
    float a;

    public Square(float a) {
        this.a = a;
    }


    @Override
    public float getPerimeter() {
        return a * 4;
    }
}
