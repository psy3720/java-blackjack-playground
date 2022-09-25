package nextstep.blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class CardTest {
    @Test
    void card_생성() {
        Card card = new Card(Number.TWO, Pattern.hearts);
        assertThat(card).isEqualTo(new Card(Number.TWO, Pattern.hearts));
        // diamonds (♢), clubs (♧), hearts (♥) and spades (♤).
    }
}
