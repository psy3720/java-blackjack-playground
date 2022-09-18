package nextstep.blackjack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputTest {
    InputView inputView;

    @BeforeEach
    void beforeEach() {
        inputView = new InputView();
    }

    @Test
    void 참가자_추가() {
        List<Participant> participantList = inputView.input("pobi,jason");
        assertThat(participantList).contains(new Participant("pobi"), new Participant("jason"));
    }

    @Test
    void 카드_분배() {
        List<Participant> participantList = inputView.input("pobi,jason");
        Dealer dealer = new Dealer();
        inputView.distributeTwoCards(participantList, dealer);

        assertThat(participantList.get(0).getCardList().size()).isEqualTo(2);
    }

    @Test
    void result() {

        Participant participant1 = new Participant("pobi");
        Participant participant2 = new Participant("jason");

        participant1.setAmount(10000);
        participant2.setAmount(30000);

        participant1.receiveCard(Arrays.asList(new Card(2, Pattern.hearts), new Card(7, Pattern.spades), new Card(11, Pattern.clubs)));
        participant2.receiveCard(Arrays.asList(new Card(7, Pattern.clubs), new Card(10, Pattern.spades), new Card(4, Pattern.spades)));

        Dealer dealer = new Dealer();
        dealer.receiveCard(Arrays.asList(new Card(3, Pattern.diamonds), new Card(9, Pattern.clubs), new Card(8, Pattern.diamonds)));

        BlackJackGame blackJackGame = new BlackJackGame(dealer, Arrays.asList(participant1, participant2));
        blackJackGame.result();
    }

    @Test
    void validate_null() {
        assertThatThrownBy(() -> inputView.input(null)).isInstanceOf(IllegalArgumentException.class);
    }
}
