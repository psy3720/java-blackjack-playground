package nextstep.blackjack;

import java.util.Random;

public class CardFactory {
    private static Card create() {
        return new Card(Number.random(), Pattern.random());
    }

    public static Card createCard() {
        return create();
    };
}
