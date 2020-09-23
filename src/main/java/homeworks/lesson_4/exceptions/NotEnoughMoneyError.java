package homeworks.lesson_4.exceptions;

public class NotEnoughMoneyError extends Exception {
    public NotEnoughMoneyError(String message) {
        super(message);
    }
}
