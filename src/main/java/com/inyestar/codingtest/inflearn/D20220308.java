package com.inyestar.codingtest.inflearn;

import com.inyestar.codingtest.runner.AbstractCodingTest;
import com.inyestar.codingtest.runner.Run;

import java.time.LocalDateTime;
import java.util.Scanner;

@Run
public class D20220308 extends AbstractCodingTest {

    private static final String DASH = "-";

    @Override
    public void test() {
        try(Scanner scanner = new Scanner(System.in)) {
            String rrn = scanner.next();
            String[] frontBack = rrn.split(DASH);
            char identity = frontBack[1].charAt(0);
            String birthYear = frontBack[0].substring(0, 2);
            String sex = null;
            int year = 0;
            year += (identity == '1' || identity == '2') ? 1900 : 2000;
            year += (birthYear.charAt(0) - 48)  * 10;
            year += birthYear.charAt(1) - 48;
            sex = (identity == '1' || identity == '3') ? "M" : "W";
            int age = LocalDateTime.now().getYear() - year;
            System.out.printf("%d %s%n", age, sex);
        }
    }
}
