package src.util;

import java.util.Scanner;

public class StringScanner {

    private final Scanner SCANNER;

    public StringScanner() {
        this.SCANNER = new Scanner(System.in);
    }

    public String getString(final String message) {
        System.out.println(message);
        return SCANNER.nextLine();
    }
}
