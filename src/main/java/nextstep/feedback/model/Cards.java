package nextstep.feedback.model;

import nextstep.feedback.PlayingCard;

import java.util.List;

public class Cards {
    List<PlayingCard> cards;

    public Cards(List<PlayingCard> cards) {
        this.cards = cards;
    }

    public void add(PlayingCard card) {
        cards.add(card);
    }

    public boolean isBust() {
        int sum = 0;

        for(PlayingCard card : cards) {
            sum += card.denomination.getScore();
        }

        return sum > 21;
    }
}
