package homeworks.lesson_4_exceptions.exceptions;

public class IncorrectPasswordError extends Exception {
    public IncorrectPasswordError(String message) {
        super(message);
    }
}
