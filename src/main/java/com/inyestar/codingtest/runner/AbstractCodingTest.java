package com.inyestar.codingtest.runner;

import org.springframework.util.StringUtils;

import java.util.*;

public abstract class AbstractCodingTest implements CodingTest{

    private static final String DELIMETER = "=";

    protected Map<String, Integer> getInputAsMap(List<String> nameList) {
        int countOfInput = nameList.size();
        Map<String, Integer> inputMap = new HashMap<>(countOfInput);
        try(Scanner scanner = new Scanner(System.in)) {
            int index = 0;
            while(scanner.hasNext()) {
                String line = scanner.next();
                String key = nameList.get(index++);
                Integer value = getValue(StringUtils.trimAllWhitespace(line), key);
                if(Objects.isNull(value)) {
                    throw new InputMismatchException("Key(String) Value(Number) ONLY!! inpue=" + line);
                }
                inputMap.put(key, value);
                if(index == countOfInput) {
                    break;
                }
            }
        }
        return inputMap;
    }

    private Integer getValue(String line, String key) {
        if(!StringUtils.hasText(line)) {
            return null;
        }
        String[] keyValue = StringUtils.split(line, DELIMETER);
        if(Objects.isNull(keyValue) || keyValue.length != 2) {
            return null;
        }
        if(!key.equals(keyValue[0])) {
            return null;
        }
        try {
            return Integer.valueOf(keyValue[1]);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    protected void printResult(Object result) {
        System.out.printf("The result is %s%n", result);
    }

    @Override
    public abstract void test();
}
