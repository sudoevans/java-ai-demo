package demo;

public final class Main {

    public static void main(final String[] args) {
        final Quote quote = new Quote(
                "Albert Einstein",
                "Learn from yesterday, live for today, hope for tomorrow. The important thing is not to stop questioning.");

        System.out.println("1 - Formatter.quote(Quote)");
        System.out.println(Formatter.multiLine(quote));
        System.out.println();

        System.out.println("2 - Quote.toString()");
        System.out.println(quote);
    }
}
