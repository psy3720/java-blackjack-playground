package nextstep.feedback.model;

import nextstep.feedback.PlayingCard;
import nextstep.feedback.Running;
import nextstep.feedback.State;

public class Hit extends Running {
    // 힛(Hit): 처음 2장의 상태에서 카드를 더 뽑는 것
    public Hit(final Cards cards) {
        super(cards);
    }

    @Override
    public State draw(final PlayingCard card) {
        cards.add(card);
        if(cards.isBust()) {
            return new Bust(cards);
        }
        return new Hit(cards);
    }

    @Override
    public State stay() {
        return new Stay(cards);
    }
}
