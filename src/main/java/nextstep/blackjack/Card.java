package nextstep.blackjack;

import java.util.Objects;

public class Card {
    private int denomination;
    private String suit;

    public Card(int denomination, String suit) {
        validate(denomination, suit);

        this.denomination = denomination;
        this.suit = suit;
    }

    private void validate(int denomination, String suit) {
        if(denomination < 1 || denomination > 11) {
            throw new IllegalArgumentException();
        }


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
}
