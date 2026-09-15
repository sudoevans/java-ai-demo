package demo.app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

public final class Main {
    public static void main(final String[] args) throws Exception {
        final Class<?> type = Class.forName("demo.domain.Quote");
        final Constructor<?> constructor = type.getConstructor(String.class, String.class);
        final Method print = type.getDeclaredMethod("print");
        print.setAccessible(true);

        try (InputStream in = type.getResourceAsStream("/quotes.csv");
             BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
            for (String line; (line = reader.readLine()) != null; ) {
                String[] parts = line.split(",", 2);
                final Object instance = constructor.newInstance(parts[0], parts[1]);
                print.invoke(instance);
            }
        }
    }
}
