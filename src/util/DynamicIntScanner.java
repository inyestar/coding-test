package src.util;

import java.util.Scanner;

public class DynamicIntScanner {

    private final Scanner SCANNER;

    public DynamicIntScanner() {
        this.SCANNER = new Scanner(System.in);
    }

    public int getInputCount() {
        System.out.println("몇 개의 숫자를 입력하실 건가요?");
        return SCANNER.nextInt();
    }

    public int[] getNumbers(final int inputCount) {
        System.out.printf("%d개의 숫자를 입력하세요.", inputCount);
        final int[] numbers = new int[inputCount];
        for(int i=0; i < inputCount; i++) {
            numbers[i] = SCANNER.nextInt();
        }
        return numbers;
    }
}
