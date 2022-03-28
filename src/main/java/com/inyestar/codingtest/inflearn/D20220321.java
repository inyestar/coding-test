package com.inyestar.codingtest.inflearn;

import com.inyestar.codingtest.runner.AbstractCodingTest;

public class D20220321 extends AbstractCodingTest {
    @Override
    public void test() {
        String malforemdStr = "B   e auT       if u L";
        String result = malforemdStr.chars()
            .filter(c -> c != ' ')
            .map(c -> c >= 65 && (char) c <= 90 ? c + 32 : (char) c)
            .collect(
                StringBuilder::new,
                StringBuilder::appendCodePoint, // ascii to human readable
                StringBuilder::append)
            .toString();
        System.out.println(result);
    }
}
