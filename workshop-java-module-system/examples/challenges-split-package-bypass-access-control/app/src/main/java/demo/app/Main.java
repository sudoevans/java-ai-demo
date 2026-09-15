package demo.app;

import demo.domain.FormatterBridge;
import demo.domain.Quote;

public final class Main {

    public static void main(final String[] args) {
        final Quote quote = new Quote(
                "Albert Einstein",
                "Learn from yesterday, live for today, hope for tomorrow. The important thing is not to stop questioning.");
        System.out.println(FormatterBridge.multiLine(quote));
    }
}
