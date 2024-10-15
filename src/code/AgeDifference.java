package src.code;

import src.util.DynamicIntScanner;
import src.util.Test;

/**
 * 입력된 N개의 나이 중 가장 차이가 많이 나는 경우
 */
@Test(date = "2024-10-15")
public class AgeDifference implements TestCode {

    private int calculate(final int[] numbers) {
        int smallest = Integer.MAX_VALUE;
        int biggest = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number < smallest) {
                smallest = number;
            }
            if (number > biggest) {
                biggest = number;
            }
        }
        return biggest - smallest;
    }

    @Override
    public void print() {
        final DynamicIntScanner scanner = new DynamicIntScanner();
        final int inputCount = scanner.getInputCount();
        final int[] numbers = scanner.getNumbers(inputCount);
        final int answer = this.calculate(numbers);
        System.out.println(answer);
    }
}
