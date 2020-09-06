package homeworks.lesson_1.figures;

public class Circle extends Figure {
    float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public float getPerimeter() {
        return 2 * (float) Math.PI * radius;
    }
}
