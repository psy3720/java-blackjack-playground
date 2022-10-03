package nextstep.blackjack;

import java.util.List;
import java.util.Objects;

public class Gamer {
    private final String name;
    private int amount;
    private final Cards cards;

    public Gamer(String name) {
        this.name = name;
        cards = new Cards();
    }

    public Gamer(String name, int amount) {
        this.name = name;
        this.amount = amount;
        cards = new Cards();
    }

    public Cards getCards() {
        return cards;
    }

    public String cardOpen() {
        return name + ": " + cards.toString();
    }

    public String getName() {
        return name;
    }

    public void receiveCard(Card card) {
        cards.add(card);
    }

    public void receiveCard(List<Card> cards) {
        this.cards.add(cards);
    }

    public int calcuateCardNumberTotal() {
        return cards.totalNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gamer gamer = (Gamer) o;
        return Objects.equals(name, gamer.name);
    }
}
