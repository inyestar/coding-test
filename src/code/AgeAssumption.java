package src.code;

import src.util.StringScanner;
import src.util.Test;

import java.time.LocalDate;

/**
 * 주민번호로 나이와 성별 계산
 */
@Test(date = "2024-10-17")
public class AgeAssumption implements TestCode {

    private int getAge(final String input) {
        int ASCII = 48;
        int birthYear = input.charAt(7) > '2' ? 2000 : 1900;
        birthYear += (input.charAt(0) - ASCII) * 10;
        birthYear += input.charAt(1) - ASCII;

        return LocalDate.now().getYear() - birthYear;
    }

    private String getSex(final String input) {
        final char eighth = input.charAt(7);
        if (eighth == '1' || eighth == '3') {
            return "M";
        }
        return "W";
    }

    @Override
    public void print() {
        final StringScanner scanner = new StringScanner();
        final String input = scanner.getString("주민번호를 입력하세요");
        final int age = this.getAge(input);
        final String sex = this.getSex(input);
        System.out.printf("%d %s%n", age, sex);
    }
}
