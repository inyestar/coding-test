package com.inyestar.codingtest.runner;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Objects;
import java.util.Optional;

public class Main {

    // TODO 패키지 분리, String[] 형태로 파싱말고 Pair로 변경
    private static final String BASE_PACKAGE = "com.inyestar.codingtest";

    /**
     * Find classes annotated as @Run <br>
     * using an API in spring-context for scanning classes
     * @param args System Arguments
     */
    public static void main(String[] args) {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(true);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Run.class));
        scanner.findCandidateComponents(BASE_PACKAGE).stream()
            .map(Main::convert)
            .filter(Objects::nonNull)
            .forEach(Main::run);
    }

    /**
     * Get class information
     * @param beanDefinition
     * @return
     */
    private static Class<CodingTest> convert(BeanDefinition beanDefinition) {
        try {
            Class<?> type = Class.forName(beanDefinition.getBeanClassName());
            Optional<Class<?>> found = Optional.ofNullable(type.getSuperclass());
            if(found.isPresent() && found.get().equals(AbstractCodingTest.class)) {
                return (Class<CodingTest>) type;
            }
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Instantiate a class found <br>
     * and then execute a method 'test'
     * @param type Class Object
     */
    private static void run(Class<CodingTest> type) {
        try {
            CodingTest instance = type.newInstance();
            instance.test();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
