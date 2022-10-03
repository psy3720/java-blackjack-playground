package nextstep.blackjack;

import java.util.List;
import java.util.Objects;

public class Dealer {
    private final String name = "딜러";
    private int amount;
    private final Cards cards;

    public Dealer() {
        this.amount = 0;
        this.cards = new Cards();
    }

    public void receiveCard(Card card) {
        cards.add(card);
    }

    public void receiveCard(List<Card> cards) {
        this.cards.add(cards);
    }

    public String getName() {
        return name;
    }

    public int calcuateCardNumberTotal() {
        return cards.totalNumber();
    }

    public String cardOpen() {
        return name + ": " + cards.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dealer dealer = (Dealer) o;
        return amount == dealer.amount && Objects.equals(name, dealer.name) && Objects.equals(cards, dealer.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, cards);
    }
}
