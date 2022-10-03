package nextstep.blackjack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class GamerTest {
    Gamer gamer;

    @BeforeEach
    void beforeEach() {
        gamer = new Gamer("철수");
    }

    @Test
    void 게이머생성() {
        assertThat(gamer).isEqualTo(new Gamer("철수"));
    }

    @Test
    void 카드를_받는다_한장() {
        gamer.receiveCard(new Card(Denomination.ACE, Suit.HEARTS));
        assertThat(gamer.getCards().contains(new Card(Denomination.ACE, Suit.HEARTS))).isTrue();
    }

    @Test
    void 카드를_받는다_여러장() {
        gamer.receiveCard(Arrays.asList(new Card(Denomination.ACE, Suit.HEARTS), new Card(Denomination.TWO, Suit.CLUBS)));
        assertThat(gamer.getCards().contains(new Card(Denomination.ACE, Suit.HEARTS))).isTrue();
        assertThat(gamer.getCards().contains(new Card(Denomination.TWO, Suit.CLUBS))).isTrue();
    }

    @Test
    void 보유하고있는_카드숫자의_합() {
        gamer.receiveCard(Arrays.asList(new Card(Denomination.ACE, Suit.HEARTS), new Card(Denomination.TWO, Suit.CLUBS)));
        int total = gamer.calcuateCardNumberTotal();
        assertThat(total).isEqualTo(3);
    }
}
