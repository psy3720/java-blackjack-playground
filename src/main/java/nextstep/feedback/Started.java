package nextstep.feedback;

import nextstep.feedback.model.Cards;

public class Started implements State{
    final Cards cards;

    public Started(Cards cards) {
        this.cards = cards;
    }

    @Override
    public State draw(PlayingCard playingCard) {
        return null;
    }

    @Override
    public State stay() {
        return null;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public Cards cards() {
        return cards;
    }

    @Override
    public Double profit(double profit) {
        return null;
    }
}
