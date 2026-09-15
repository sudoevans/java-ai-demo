package demo.app;

import demo.common.Formatter;
import demo.common.StringUtils;
import demo.domain.Quote;

public final class Main {

    public static void main(final String[] args) {
        final String author = StringUtils.toUpperCase("Albert Einstein");
        final Quote quote = new Quote(author, "Learn from yesterday, live for today, hope for tomorrow. The important thing is not to stop questioning.");
        System.out.println(Formatter.multiline(quote));
    }
}
