package homeworks.lesson_1_sort_search_converter.figures;

public class Rect extends Figure {
    float width;
    float height;

    public Rect(float width, float height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public float getPerimeter() {
        return 2 * (width + height);
    }
}
