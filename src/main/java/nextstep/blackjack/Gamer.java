package nextstep.blackjack;

import java.util.List;
import java.util.Objects;

public class Gamer {
    private final String name;
    private final Cards cards;

    public Gamer(String name) {
        this.name = name;
        cards = new Cards();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gamer gamer = (Gamer) o;
        return Objects.equals(name, gamer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void receiveCard(Card card) {
        cards.add(card);
    }

    public void receiveCard(List<Card> cards) {
        this.cards.add(cards);
    }
}
