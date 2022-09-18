package nextstep.blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class CardTest {
    @Test
    void card_생성() {
        Card card = new Card(2, Pattern.hearts);
        Assertions.assertThat(card).isEqualTo(new Card(2, Pattern.hearts));
        // diamonds (♢), clubs (♧), hearts (♥) and spades (♤).
    }
}
