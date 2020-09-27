package homeworks.lesson_4_exceptions;

import homeworks.lesson_4_exceptions.exceptions.AccountIsLockedException;
import homeworks.lesson_4_exceptions.exceptions.IncorrectPasswordError;
import homeworks.lesson_4_exceptions.exceptions.InvalidPasswordError;

import java.util.concurrent.atomic.AtomicInteger;

public class PinValidator {
    final static String MY_PASSWORD = "1234";
    AtomicInteger attempts = new AtomicInteger(3);
    AtomicInteger secondsLeft = new AtomicInteger(0);

    void auth(String password) throws InvalidPasswordError, AccountIsLockedException {
        if (secondsLeft.get() > 0)
            throw new AccountIsLockedException(String.format("Аккаунт заблокирован. До разблокировки осталось %d сек", secondsLeft.get()));

        if (!password.equals(MY_PASSWORD)) {
            attempts.set(attempts.get() - 1);

            if (attempts.get() == 0) {
                secondsLeft.set(10);

                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        while (secondsLeft.get() > 0) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            secondsLeft.set(secondsLeft.get() - 1);
                        }
                        attempts.set(3);
                    }
                };
                thread.start();

                throw new AccountIsLockedException(String.format("Аккаунт заблокирован. До разблокировки осталось %d сек", secondsLeft.get()));
            }

            throw new InvalidPasswordError(String.format("Неправильный пароль. У Вас остаось %d попытки(а)", attempts.get()));
        }
    }

    void validate(String password) throws IncorrectPasswordError {
        if (!password.matches("^\\d*$"))
            throw new IncorrectPasswordError("Пароль должен состоять только из цифр");
    }
}
