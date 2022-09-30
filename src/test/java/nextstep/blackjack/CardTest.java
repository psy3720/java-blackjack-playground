package nextstep.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CardTest {

    @Test
    void 카드생성() {
        Card card = new Card(1, "hearts");
        assertThat(card).isEqualTo(new Card(1, "hearts"));
    }

    @Test
    void 올바르지않은_카드생성() {
        assertThatThrownBy(() -> new Card(12, "asdf")).isInstanceOf(IllegalArgumentException.class);
    }
}
