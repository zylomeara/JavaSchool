package homeworks.lesson_1.figures;

public class Triangle extends Figure {
    float a;
    float b;
    float c;

    public Triangle(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public float getPerimeter() {
        return a + b + c;
    }
}
