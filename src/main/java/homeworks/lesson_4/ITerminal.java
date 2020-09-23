package homeworks.lesson_4;

import homeworks.lesson_4.exceptions.MultiplicitySumMoneyError;
import homeworks.lesson_4.exceptions.NotEnoughMoneyError;
import homeworks.lesson_4.exceptions.PositiveNumberError;

public interface ITerminal {
    int checkBalance();
    void putMoney(int num) throws PositiveNumberError, MultiplicitySumMoneyError;
    void takeMoney(int num) throws NotEnoughMoneyError, PositiveNumberError, MultiplicitySumMoneyError;
}
