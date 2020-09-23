package homeworks.lesson_4.exceptions;

public class IncorrectPasswordError extends Exception {
    public IncorrectPasswordError(String message) {
        super(message);
    }
}
