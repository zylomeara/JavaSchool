package homeworks.lesson_4.exceptions;

public class InvalidPasswordError extends Exception {
    public InvalidPasswordError(String msg) {
        super(msg);
    }
}
