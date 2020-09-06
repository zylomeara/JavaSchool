package homeworks.lesson_1;

public class CelsiumConverter {
    private final float celsium;
    public CelsiumConverter(float celsium) {
        this.celsium = celsium;
    }

    public float getFahrenheit() {
        return celsium * 9/5 + 32;
    }

    public float getKelvin() {
        return celsium + 273.15f;
    }
}
