package nextstep.blackjack;

import java.util.Objects;

public class Card {
    private Denomination denomination;
    private Suit suit;

    public Card(Denomination denomination, Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return denomination == card.denomination && Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(denomination, suit);
    }

    @Override
    public String toString() {
        if(denomination.isAce() || denomination.number == 10) {
            return denomination.getName() + suit.getName();
        }

        return denomination.number + suit.getName();
    }
}
