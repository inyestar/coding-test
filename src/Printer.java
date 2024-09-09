package src;

import src.code.TestCode;
import src.util.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Printer {

    private static final String PACKAGE_NAME_SLASH = "src/code";
    private static final String PACKAGE_NAME_DOT = "src.code";

    public static void main(String [] args) throws Exception {
        final Printer printer = new Printer();
        Optional.ofNullable(printer.getInstance()).ifPresent(TestCode::print);
    }

    private TestCode getInstance() throws IOException {
        final URL rootPackageUrl = this.getRootPackageUrl();
        final File directory = new File(rootPackageUrl.getFile());
        return this.getClasses(directory)
                .stream()
                .filter(this::isTodayTestCode)
                .findFirst()
                .map(this::getNewInstance)
                .orElse(null);
    }

    private URL getRootPackageUrl() throws IOException {
        Enumeration<URL> resources = ClassLoader.getSystemClassLoader().getResources(PACKAGE_NAME_SLASH);
        return resources.asIterator().next();
    }

    private List<Class> getClasses(final File directory) {
        return Arrays.stream(Optional.ofNullable(directory.listFiles()).orElseThrow())
                .filter(file -> !file.getName().contains("TestCode"))
                .map(file -> this.getClass(file.getName()))
                .filter(Objects::nonNull)
                .toList();
    }

    private Class getClass(final String fileName) {
        try {
            return Class.forName(this.getFullClassName(fileName));
        } catch (RuntimeException | ClassNotFoundException e) {
            return null;
        }
    }

    private String getFullClassName(final String className) {
        final String removedExtension = className.replaceFirst(".class", "");
        return String.format("%s.%s", PACKAGE_NAME_DOT, removedExtension);
    }

    private boolean isTodayTestCode(final Class testCode) {
        final String today = this.getToday();
        return Optional.ofNullable(testCode.getDeclaredAnnotation(Test.class))
                .map(annotation -> {
                    Test test  = (Test) annotation;
                    return test.date().equals(today);
                })
                .orElse(false);
    }

    private String getToday() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    private TestCode getNewInstance(Class testCodeClass) {
        try {
            return (TestCode) testCodeClass.getConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}
