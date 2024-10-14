package src.code;

import src.util.IntScanner;
import src.util.Test;

import java.util.stream.IntStream;

/**
 * 자연수 N의 진약수의 합
 */
@Test(date = "2024-10-14")
public class ProperDivisor implements TestCode {

    private int calculate(final int n) {
        System.out.print(1);
        return IntStream.range(2, n)
                .filter(i -> n % i == 0)
                .peek(i -> System.out.printf(" + %d", i))
                .sum();
    }

    @Override
    public void print() {
        final IntScanner intScanner = new IntScanner(1);
        final int[] input = intScanner.getInput();
        final int n = input[0];
        final int result = this.calculate(n) + 1;
        System.out.printf("%s%n", result > 1 ? " = " + result : "");
    }
}
