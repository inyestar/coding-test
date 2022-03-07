package com.inyestar.codingtest.inflearn;

import com.inyestar.codingtest.runner.AbstractCodingTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class D20220304  extends AbstractCodingTest {
    @Override
    public void test() {
        List<String> nameList = Arrays.asList("n");
        Map<String, Integer> inputMap = getInputAsMap(nameList);
        final int n = inputMap.get(nameList.get(0));
        StringBuilder builder = new StringBuilder();
        builder.append(1);
        int sum = 1;
        sum += IntStream.range(2, n)
            .filter(i -> n % i == 0)
            .peek(i -> builder.append(" + ").append(i))
            .sum();
        builder.append(" = ").append(sum);
        System.out.println(builder.toString());
    }
}
