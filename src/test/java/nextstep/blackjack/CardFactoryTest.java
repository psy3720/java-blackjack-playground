package nextstep.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardFactoryTest {

    @Test
    void random_카드() {
        Card card = CardFactory.createCard();

        System.out.println("card.number = " + card.number);
        System.out.println("card.pattern.name = " + card.pattern.name);

        assertThat(card).isEqualTo(new Card(1, Pattern.random()));
    }
}
