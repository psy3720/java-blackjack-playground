package nextstep.blackjack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CardsTest {
    Cards cards;

    @BeforeEach
    void beforeEach() {
      cards = new Cards(Arrays.asList(new Card(Denomination.TWO, Suit.HEARTS)));
    }

    @Test
    void 카드묶음생성() {
        assertThat(cards).isEqualTo(new Cards(Arrays.asList(new Card(Denomination.TWO, Suit.HEARTS))));
    }

    @Test
    void 카드포함하고있는지여부() {
        boolean isContain = cards.contains(new Card(Denomination.TWO, Suit.HEARTS));
        assertThat(isContain).isTrue();
    }

    @Test
    void 게임카드_생성() {
        PlayingCard playingCard = new PlayingCard();
        Cards cards1 = playingCard.getCards();
        assertThat(cards1.size()).isEqualTo(48);
    }

    @Test
    void 랜덤카드뽑기() {
        PlayingCard playingCard = new PlayingCard();
        Card randomCard = playingCard.draw();
        System.out.println("randomCard = " + randomCard.toString());
        assertThat(playingCard.getCards().size()).isEqualTo(47);
    }
}
