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
      cards = new Cards(Arrays.asList(new Card(2, "hearts")));
    }

    @Test
    void 카드묶음생성() {
        assertThat(cards).isEqualTo(new Cards(Arrays.asList(new Card(2, "hearts"))));
    }

    @Test
    void 카드포함하고있는지여부() {
        boolean isContain = cards.contains(new Card(2, "hearts"));
        assertThat(isContain).isTrue();
    }
}
