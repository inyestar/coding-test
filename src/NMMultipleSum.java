package src;

import src.util.IntScanner;

import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * 1부터 N까지의 M의 배수합
 */
public class NMMultipleSum {

    private int calculate(final int n, final int m) {
        return IntStream.range(1, n + 1)
                .filter(i -> i % m == 0)
                .sum();
    }

    public static void main(String[] args) {
        final IntScanner intScanner = new IntScanner(2);
        final int[] input = intScanner.getInput();
        final int n = input[0];
        final int m = input[1];
        final int result = new NMMultipleSum().calculate(n, m);
        System.out.println(result);
    }
}


