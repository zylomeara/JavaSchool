package homeworks.lesson_4;

import homeworks.lesson_4.exceptions.MultiplicitySumMoneyError;
import homeworks.lesson_4.exceptions.NotEnoughMoneyError;
import homeworks.lesson_4.exceptions.PositiveNumberError;

public class TerminalServer implements ITerminal {
    int balance = 1000;

    public int checkBalance() {
        return balance;
    }

    public void putMoney(int num) throws PositiveNumberError, MultiplicitySumMoneyError {
        if (num % 100 != 0)
            throw new MultiplicitySumMoneyError("Введите сумму кратной 100");

        if (num <= 0)
            throw new PositiveNumberError("Введите положительное число");

        balance = balance + num;
    }

    public void takeMoney(int num) throws NotEnoughMoneyError, PositiveNumberError, MultiplicitySumMoneyError {
        if (num <= 0)
            throw new PositiveNumberError("Введите положительное число");

        if (num % 100 != 0)
            throw new MultiplicitySumMoneyError("Введите сумму кратной 100");

        if (num > balance) {
            throw new NotEnoughMoneyError("Недостаточно денег на счете");
        }

        balance = balance - num;
    }
}
