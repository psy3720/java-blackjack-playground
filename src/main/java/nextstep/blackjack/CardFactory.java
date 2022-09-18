package nextstep.blackjack;

import java.util.Random;

public class CardFactory {
    private static Card create() {
        return new Card(new Random().nextInt(11)+1, Pattern.random());
    }

    public static Card createCard() {
        return create();
    };
}
