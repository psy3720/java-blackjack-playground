package nextstep.feedback;

import nextstep.feedback.model.*;

import java.util.Arrays;

public class BlackJackMain {
    public static void main(String[] args) {
        Hit hit = new Hit(new Cards(Arrays.asList(new PlayingCard(Denomination.ACE, Suit.CLUBS))));
        State draw = hit.draw(new PlayingCard(Denomination.ACE, Suit.CLUBS));
    }
}
