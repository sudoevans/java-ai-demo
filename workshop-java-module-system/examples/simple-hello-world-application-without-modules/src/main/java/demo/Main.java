package demo;

public final class Main {

    public static void main(final String[] args) {
        System.out.println("Simple hello world application (without modules)");
        System.out.println("Using Java " + System.getProperty("java.version"));

        final Module module = Main.class.getModule();
        if (module.isNamed()) {
            System.out.println("Loaded as module with Name: " + module.getName() + " (JAR file loaded through the module path)");
        } else {
            System.out.println("Loaded as unmaned module (JAR file loaded through the class path)");
        }
    }
}
