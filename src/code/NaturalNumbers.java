package src.code;

import src.util.IntScanner;
import src.util.Test;

import java.util.stream.IntStream;

/**
 * N부터 M까지의 자연수의 합
 */
@Test(date = "2024-09-09")
public class NaturalNumbers implements TestCode {

    private int calculate(final int n, final int m) {
        return IntStream.range(n, m + 1)
                .peek(i -> System.out.print(i + (i == m ? " = " : " + ")))
                .sum();
    }

    @Override
    public void print() {
        final IntScanner intScanner = new IntScanner(2);
        final int[] input = intScanner.getInput();
        final int n = input[0];
        final int m = input[1];
        final int result = this.calculate(n, m);
        System.out.println(result);
    }
}
