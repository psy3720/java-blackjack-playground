package nextstep.blackjack;

import java.util.Objects;

public class Card {
    final int number;
    final Pattern pattern;

    public Card(int number, Pattern pattern) {
        this.number = number;
        this.pattern = pattern;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return number == card.number && Objects.equals(pattern, card.pattern);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, pattern);
    }
}
