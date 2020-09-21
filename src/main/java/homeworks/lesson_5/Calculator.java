package homeworks.lesson_5;

public class Calculator implements ICalculator {
    final int UPPER_INT_BOUND = 32;
    final int LOWER_INT_BOUND = 0;

    @Override
    public int calc(int number) {
        assert number < UPPER_INT_BOUND && number >= LOWER_INT_BOUND : "Invalid number found";

        int result = 1;
        for (int i = 1; i <= number; i++){
            result = result * i;
        }

        try {
            Thread.sleep(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }
}
