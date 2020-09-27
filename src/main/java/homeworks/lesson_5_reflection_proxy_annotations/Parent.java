package homeworks.lesson_5_reflection_proxy_annotations;

public class Parent {
    public static final String MONDAY = "MONDAY";
    int i = 0;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    private void say() {
        System.out.println("hello");
    }

    public void say2() {
        System.out.println("hello");
    }
}
