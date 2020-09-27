package homeworks.lesson_4_exceptions.exceptions;

public class NotEnoughMoneyError extends Exception {
    public NotEnoughMoneyError(String message) {
        super(message);
    }
}
