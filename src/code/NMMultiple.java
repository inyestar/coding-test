package src.code;

import src.util.IntScanner;
import src.util.Test;

import java.util.stream.IntStream;

/**
 * 1부터 N까지의 M의 배수합
 */
@Test(date = "2024-09-03")
public class NMMultiple implements TestCode {

    private int calculate(final int n, final int m) {
        return IntStream.range(1, n + 1)
                .filter(i -> i % m == 0)
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


