package nextstep.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CardTest {

    @Test
    void 카드생성() {
        Card card = new Card(Denomination.ACE, Suit.HEARTS);
        assertThat(card).isEqualTo(new Card(Denomination.ACE, Suit.HEARTS));
    }
}
