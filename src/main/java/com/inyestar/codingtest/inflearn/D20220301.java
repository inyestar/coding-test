package com.inyestar.codingtest.inflearn;

import com.inyestar.codingtest.runner.AbstractCodingTest;
import com.inyestar.codingtest.runner.Run;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Run
public class D20220301 extends AbstractCodingTest {

    @Override
    public void test() {
        List<String> nameList = Arrays.asList("n", "m");
        Map<String, Integer> inputMap = getInputAsMap(nameList);
        final int n = inputMap.get(nameList.get(0));
        final int m = inputMap.get(nameList.get(1));
        int sum = IntStream.range(1, n + 1)
                .filter(i -> i % m == 0)
                .sum();
        printResult(sum);
    }
}
