package src.util;

import java.util.Scanner;

public class IntScanner {

    private final Scanner SCANNER;
    private final int COUNT;
    private final int[] INPUT;

    public IntScanner(final int count) {
        this.SCANNER = new Scanner(System.in);
        this.COUNT = count;
        this.INPUT = initialize();
    }

    private void setInput() {
        for(int i=0; i < COUNT; i++) {
            INPUT[i] = SCANNER.nextInt();
        }
    }

    private int[] initialize() {
        return new int[COUNT];
    }

    private void notice() {
        System.out.printf("%d개의 숫자를 입력하세요.", COUNT);
    }

    public int[] getInput() {
        this.notice();
        this.setInput();
        return INPUT;
    }
}
