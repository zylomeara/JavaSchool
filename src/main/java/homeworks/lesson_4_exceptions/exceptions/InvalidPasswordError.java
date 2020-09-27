package homeworks.lesson_4_exceptions.exceptions;

public class InvalidPasswordError extends Exception {
    public InvalidPasswordError(String msg) {
        super(msg);
    }
}
