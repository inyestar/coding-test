package com.inyestar.codingtest.inflearn;

import com.inyestar.codingtest.runner.AbstractCodingTest;
import com.inyestar.codingtest.runner.Run;

import java.util.stream.IntStream;

@Run
public class D20220329 extends AbstractCodingTest {

    public void beforeOptimization() {
        int n = 8;
        int cnt = 0;
        for(int i=1; i<=n; i++) {
            cnt = 0;
            for(int j=1; j<=i; j++) {
                // n이 20000, i가 10000이면 j는 10000번 루프 돌아야함 N^2
                if(i%j == 0) {
                    cnt++;
                }
            }
            System.out.printf("%d=%d%n", i, cnt);
        }
    }

    @Override
    public void test() {
        int n = 10;
        int[] divisors = new int[n + 1]; // 0은 제외
        for(int i=1; i<=n; i++) {
            // n이 20000, i가 10000이면 j는 2번 돌면됨
            for(int j=i; j<=n; j=j+i) {
                divisors[j]++;
            }
        }
        IntStream.range(1, n + 1)
            .forEach(i -> System.out.printf("%d=%d %n", i, divisors[i]));
    }
}
