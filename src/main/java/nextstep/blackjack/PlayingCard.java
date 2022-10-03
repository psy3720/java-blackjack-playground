package nextstep.blackjack;

import java.util.ArrayList;
import java.util.List;

public class PlayingCard {
    Cards cards;

    public PlayingCard() {
        cards = new Cards();
        created();
    }

    public Cards getCards() {
        return cards;
    }

    public Card draw() {
        return cards.getRandomCard().get();
    }

    public List<Card> draw(int num) {
        List<Card> result = new ArrayList<>();

        for(int i=0; i<num; i++) {
            Card card = cards.getRandomCard().get();
            result.add(card);
        }

        return result;
    }

    private void created() {
        Denomination[] denominations = Denomination.values();
        Suit[] suits = Suit.values();

        for(int i=0; i<suits.length; i++) {
            for(int j=0; j<denominations.length; j++) {
                Card card = new Card(denominations[j], suits[i]);
                cards.add(card);
            }
        }
    }
}
