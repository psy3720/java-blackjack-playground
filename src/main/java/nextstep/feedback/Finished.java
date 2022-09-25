package nextstep.feedback;

import nextstep.feedback.model.Cards;

public class Finished extends Started{
    public Finished(Cards cards) {
        super(cards);
    }

    @Override
    public State draw(PlayingCard playingCard) {
        return super.draw(playingCard);
    }

    @Override
    public State stay() {
        return super.stay();
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }

    @Override
    public Double profit(double profit) {
        return super.profit(profit);
    }

    public Double earningRate() {
        return null;
    }
}
