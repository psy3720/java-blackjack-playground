package nextstep.feedback.model;

import nextstep.feedback.Finished;

public class Stay extends Finished {
    public Stay(final Cards cards) {
        super(cards);
    }
    // 스테이(Stay): 카드를 더 뽑지 않고 차례를 마치는 것

    @Override
    public Double earningRate() {
        return 1.0;
    }
}
