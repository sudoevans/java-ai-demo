package demo.mem;

import demo.spi.Quote;
import demo.spi.QuoteService;

import java.util.List;
import java.util.Optional;
import java.util.random.RandomGenerator;

public class InMemoryQuoteService implements QuoteService {

    private final List<Quote> quotes = createQuotes();

    @Override
    public Optional<Quote> random() {
        final RandomGenerator random = RandomGenerator.getDefault();
        final int size = quotes.size();
        final int index = random.nextInt(size);

        return Optional.of(quotes.get(index));
    }

    private static List<Quote> createQuotes() {
        return List.of(
                new Quote("Nelson Mandela", "The greatest glory in living lies not in never falling, but in rising every time we fall."),
                new Quote("Walt Disney", "The way to get started is to quit talking and begin doing."),
                new Quote("Steve Jobs", "Your time is limited, so don't waste it living someone else's life. Don't be trapped by dogma - which is living with the results of other people's thinking."),
                new Quote("Eleanor Roosevelt", "If life were predictable it would cease to be life, and be without flavor."),
                new Quote("Oprah Winfrey", "If you look at what you have in life, you'll always have more. If you look at what you don't have in life, you'll never have enough."),
                new Quote("James Cameron", "If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success."),
                new Quote("John Lennon", "Life is what happens when you're busy making other plans."),
                new Quote("Lao Tzu", "The journey of a thousand miles begins with one step."),
                new Quote("Friedrich Nietzsche", "That which does not kill us makes us stronger."),
                new Quote("Joe Kennedy", "When the going gets tough, the tough get going."),
                new Quote("Mahatma Gandhi", "You must be the change you wish to see in the world."),
                new Quote("Mae West", "You only live once, but if you do it right, once is enough."),
                new Quote("Robert H. Schuller", "Tough times never last but tough people do."),
                new Quote("Stephen King", "Get busy living or get busy dying."),
                new Quote("Henry Ford", "Whether you think you can or you think you can't, you're right."),
                new Quote("Alrded Lord Tennyson", "Tis better to have loved and lost than to have never loved at all."));
    }
}
