package demo.domain;

public final class Helper {

    public static Quote create() {
        return new Quote("Albert Einstein", "Learn from yesterday, live for today, hope for tomorrow. The important thing is not to stop questioning.");
    }

    private Helper() {}
}
