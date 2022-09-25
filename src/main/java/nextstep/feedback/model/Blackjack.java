package nextstep.feedback.model;

import nextstep.feedback.Finished;

public class Blackjack extends Finished {
    public Blackjack(final Cards cards) {
        super(cards);
    }

    // 블랙잭(Blackjack): 처음 두 장의 카드 합이 21인 경우, 베팅 금액의 1.5배
    @Override
    public Double earningRate() {
        return 1.5;
    }
}
