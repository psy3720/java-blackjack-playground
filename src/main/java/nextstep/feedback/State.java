package nextstep.feedback;

import nextstep.feedback.model.Cards;

public interface State {
    State draw(PlayingCard playingCard);
    State stay();
    boolean isFinished();
    Cards cards();
    Double profit(double profit);
}
