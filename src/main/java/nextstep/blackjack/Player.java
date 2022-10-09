package nextstep.blackjack;

import java.util.List;
import java.util.Objects;

public abstract class Player {
    private final String name;
    protected int amount;
    private final Cards cards;

    public Player(String name) {
        this.cards = new Cards();
        this.amount = 0;
        this.name = name;
    }

    public Player(String name, int amount) {
        this.cards = new Cards();
        this.amount = amount;
        this.name = name;
    }

    public void lose() {
        int amount = this.amount;
        this.amount = 0;
        this.amount -= amount;
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

    public String cardOpen() {
        return name + ": " + cards.toString();
    }

    public String getName() {
        return name;
    }

    public Cards getCards() {
        return cards;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return amount == player.amount && Objects.equals(name, player.name) && Objects.equals(cards, player.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, cards);
    }
}
