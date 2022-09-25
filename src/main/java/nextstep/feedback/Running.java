package nextstep.feedback;

import nextstep.feedback.model.Cards;

public class Running extends Started{
    public Running(Cards cards) {
        super(cards);
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }

    @Override
    public Double profit(double profit) {
        return super.profit(profit);
    }
}
