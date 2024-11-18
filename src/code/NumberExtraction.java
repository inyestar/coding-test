package src.code;

import src.util.StringScanner;
import src.util.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Test(date = "2024-11-18")
public class NumberExtraction implements TestCode {

    private int calculate(final String input) {
        final LinkedList<Integer> numbers = input.chars()
                .filter(x -> x > 47 && x < 58)
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toCollection(LinkedList::new));
        return this.integrateNumbers(numbers);
    }

    private int integrateNumbers(final List<Integer> numbers) {
        int number = 0;
        for(int i=0; i<numbers.size(); i++) {
            number = number * 10 + numbers.get(i);
        }
        return number;
    }

    private long getDivisor(final int number) {
        return IntStream.range(1, number + 1)
                .filter(i -> number % i == 0)
                .count();
    }

    @Override
    public void print() {
        final StringScanner scanner = new StringScanner();
        final String input = scanner.getString("아무것이나 입력하세요");
        final int number = this.calculate(input);
        System.out.println(number);
        final long divisor = this.getDivisor(number);
        System.out.println(divisor);
    }
}
