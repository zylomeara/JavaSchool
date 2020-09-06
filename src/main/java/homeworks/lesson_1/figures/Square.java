package homeworks.lesson_1.figures;

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
