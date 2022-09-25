package nextstep.feedback.model;

import nextstep.feedback.Finished;

public class Bust extends Finished {
    public Bust(final Cards cards) {
        super(cards);
    }

    // 버스트(Bust): 카드 총합이 21을 넘는 경우. 배당금을 잃는다.
    @Override
    public Double earningRate() {
        return 0.0;
    }
}
