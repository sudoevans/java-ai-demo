package demo;

public final class Main {

    public static void main(final String[] args) {
        System.out.println("JEP 238: Multi-Release JAR Files");
        System.out.println("Java version: " + System.getProperty("java.version"));

        final Describable describable = new Demo();
        System.out.println(describable.describe());
    }
}
