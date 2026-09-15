package demo.app;

import demo.domain.Formatter;
import demo.domain.Helper;
import demo.domain.Quote;

public final class Main {

    public static void main(final String[] args) {
        final Quote quote = Helper.create();
        System.out.println(Formatter.multiLine(quote));
    }
}
