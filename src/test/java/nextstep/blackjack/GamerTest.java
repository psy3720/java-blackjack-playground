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
        gamer.receiveCard(new Card(1, "hearts"));
    }

    @Test
    void 카드를_받는다_여러장() {
        gamer.receiveCard(Arrays.asList(new Card(1, "hearts"), new Card(2, "clubs")));
    }
}
