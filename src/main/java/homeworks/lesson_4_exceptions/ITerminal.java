package homeworks.lesson_4_exceptions;

import homeworks.lesson_4_exceptions.exceptions.MultiplicitySumMoneyError;
import homeworks.lesson_4_exceptions.exceptions.NotEnoughMoneyError;
import homeworks.lesson_4_exceptions.exceptions.PositiveNumberError;

public interface ITerminal {
    int checkBalance();
    void putMoney(int num) throws PositiveNumberError, MultiplicitySumMoneyError;
    void takeMoney(int num) throws NotEnoughMoneyError, PositiveNumberError, MultiplicitySumMoneyError;
}
