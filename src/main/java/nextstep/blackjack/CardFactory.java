package nextstep.blackjack;

import java.util.Random;

public class CardFactory {
    private static Card create() {
        Random random = new Random();
        int number = random.nextInt(11)+1;

        return new Card(number, Pattern.random());
    }

    public static Card createCard() {
        return create();
    };
}
