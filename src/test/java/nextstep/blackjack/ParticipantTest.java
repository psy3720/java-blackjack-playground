package nextstep.blackjack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {
    @Test
    void 플레이어_생성() {
        Participant pobi = new Participant("pobi");
        assertThat(pobi).isEqualTo(new Participant("pobi"));
    }

    @Test
    void 배팅금액은_10000() {
        Participant pobi = new Participant("pobi");
        pobi.setAmount(10000);

        assertThat(pobi.getAmount()).isEqualTo(10000);
    }

    @Test
    void 카드를_받아보자() {
        Participant pobi = new Participant("pobi");
        Card card = new Card(2, Pattern.diamonds);
        pobi.receiveCard(card);
        assertThat(pobi.hasCard(card)).isTrue();
    }

    @Test
    void 결과_계산() {
        Participant pobi = new Participant("pobi");
        pobi.receiveCard(Arrays.asList(new Card(2, Pattern.diamonds), new Card(3, Pattern.clubs)));

        assertThat(pobi.calculateCardSum()).isEqualTo(5);
    }

}
