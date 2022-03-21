package com.inyestar.codingtest.inflearn;

import com.inyestar.codingtest.runner.AbstractCodingTest;

public class D20220310 extends AbstractCodingTest {
    @Override
    public void test() {
        String strWithNumber = "wefad0sd0f12dsd7fa9ef0dd0";
        int result = 0;
        for(char c : strWithNumber.toCharArray()) {
            if(c >= 48 && c <= 58) {
                result *= 10; // jump to forward
                result += c - 48;
            }
        }
        System.out.println(result);
    }
}
