package com.inyestar.codingtest.inflearn;

import com.inyestar.codingtest.runner.AbstractCodingTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class D20220303 extends AbstractCodingTest {
    @Override
    public void test() {
        List<String> nameList = Arrays.asList("n", "m");
        Map<String, Integer> inputMap = getInputAsMap(nameList);
        final int n = inputMap.get(nameList.get(0));
        final int m = inputMap.get(nameList.get(1));
        int sum = IntStream.range(n, m)
            .peek(i -> System.out.print(i + " + "))
            .sum();
        System.out.print(m + " = ");
        System.out.println(sum);
    }
}
