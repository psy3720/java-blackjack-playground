package nextstep.blackjack;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Cards {
    private List<Card> cards;

    public Cards() {
    }

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cards cards1 = (Cards) o;
        return Objects.equals(cards, cards1.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }

    public boolean contains(Card card) {
        return cards.contains(card);
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void add(List<Card> cards) {
        this.cards.addAll(cards);
    }
}
