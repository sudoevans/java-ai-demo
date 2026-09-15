package demo.app;

import demo.compute.Computation;
import demo.domain.Quote;

public final class Main {

    public static void main(final String[] args) {
        final Quote quote = new Quote("Albert Einstein", "Learn from yesterday, live for today, hope for tomorrow. The important thing is not to stop questioning.");
        System.out.println(quote);

        System.out.println(new Computation(3, "*", 7));
        System.out.println(new Computation(3, "/", 7));
    }
}
