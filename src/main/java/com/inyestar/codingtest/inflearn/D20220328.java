package com.inyestar.codingtest.inflearn;

import com.inyestar.codingtest.runner.AbstractCodingTest;
import com.inyestar.codingtest.runner.Run;

@Run
public class D20220328 extends AbstractCodingTest {
    @Override
    public void test() {
        String input = "(()))(";
        int cnt = 0;
        for(char c : input.toCharArray()) {
            if(c == '(') {
                cnt++;
            }
            if(c == ')') {
                cnt--;
            }
            if(cnt < 0) {
                break;
            }
        }
        System.out.println(cnt == 0 ? "YES" : "NO");
    }
}
