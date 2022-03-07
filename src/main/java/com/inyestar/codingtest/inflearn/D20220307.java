package com.inyestar.codingtest.inflearn;

import com.inyestar.codingtest.runner.AbstractCodingTest;
import com.inyestar.codingtest.runner.Run;

import java.util.Scanner;

@Run
public class D20220307 extends AbstractCodingTest {
    @Override
    public void test() {
        // TODO: 파일 읽기로 변경
        try(Scanner scanner = new Scanner(System.in)) {
            int cnt = scanner.nextInt();
            int idx = 0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            while(idx++ < cnt) {
                int num = scanner.nextInt();
                if(num > max) {
                    max = num;
                }
                if(num < min) {
                    min = num;
                }
            }
            System.out.println(max - min);
        }
    }
}
