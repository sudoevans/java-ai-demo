package demo;

import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class Main {

    public static void main(final String[] args) {
        printSystemProperties();
        printParameters(args);
    }

    private static void printSystemProperties() {
        Predicate<Map.Entry<Object, Object>> isApplicationProperty =
                e -> e.getKey() instanceof String k && k.startsWith("app.");

        var properties = System.getProperties().entrySet().stream()
                .filter(isApplicationProperty)
                .collect(Collectors.toSet());

        System.out.printf("Has %d properties (that starts with 'app.')%n", properties.size());
        properties.forEach(e -> System.out.printf(" - [%s] '%s'%n", e.getKey(), e.getValue()));
    }

    private static void printParameters(final String... args) {
        System.out.printf("Received %d parameters%n", args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.printf(" - [%d] '%s'%n", i, args[i]);
        }
    }
}
