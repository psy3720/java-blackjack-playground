package nextstep.blackjack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @Test
    void 플레이어_생성() {
        Player pobi = new Player("pobi");
        assertThat(pobi).isEqualTo(new Player("pobi"));
    }

    @Test
    void 배팅금액은_10000() {
        Player pobi = new Player("pobi");
        pobi.setBetAmount(10000);

        assertThat(pobi.getBetAmount()).isEqualTo(10000);
    }

    @Test
    void 카드를_받아보자() {
        Player pobi = new Player("pobi");
        Card card = new Card(2, Pattern.diamonds);
        pobi.receiveCard(card);
        assertThat(pobi.hasCard(card)).isTrue();
    }

    @Test
    void 결과_계산() {
        Player pobi = new Player("pobi");
        pobi.receiveCard(Arrays.asList(new Card(2, Pattern.diamonds), new Card(3, Pattern.clubs)));

        assertThat(pobi.calculateCardSum()).isEqualTo(5);
    }

}
