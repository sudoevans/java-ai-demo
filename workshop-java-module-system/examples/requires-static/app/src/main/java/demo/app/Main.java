package demo.app;

import demo.domain.Quote;
import demo.formatter.Formatter;

public final class Main {

    public static void main(final String[] args) {
        final Quote quote = new Quote(
                "Albert Einstein",
                "Learn from yesterday, live for today, hope for tomorrow. The important thing is not to stop questioning.");

        if (isModulePresent("demo.formatter")) {
            System.out.println("Formatter module found!");
            final String multiLine = Formatter.multiLine(quote);
            System.out.println(multiLine);
        } else {
            System.out.println("Formatter module NOT found!");
            System.out.println(quote);
        }
    }

    public static boolean isModulePresent(final String moduleName) {
        return searchRootModuleLayer()
                .findModule(moduleName)
                .isPresent();
    }

    private static ModuleLayer searchRootModuleLayer() {
        return Main.class
                .getModule()
                .getLayer();
    }
}
