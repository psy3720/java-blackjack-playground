package nextstep.blackjack;

import org.assertj.core.api.Assertions;
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
        List<Player> playerList = inputView.input("pobi,jason");
        assertThat(playerList).contains(new Player("pobi"), new Player("jason"));
    }

    @Test
    void 카드_분배() {
        List<Player> playerList = inputView.input("pobi,jason");
        inputView.distributeTwoCards(playerList);

        assertThat(playerList.get(0).getCardList().size()).isEqualTo(2);
    }

    @Test
    void result() {

        Player player1 = new Player("pobi");
        Player player2 = new Player("jason");

        player1.setBetAmount(10000);
        player2.setBetAmount(30000);

        player1.receiveCard(Arrays.asList(new Card(2, Pattern.hearts), new Card(7, Pattern.spades), new Card(11, Pattern.clubs)));
        player2.receiveCard(Arrays.asList(new Card(7, Pattern.clubs), new Card(10, Pattern.spades), new Card(4, Pattern.spades)));

        Dealer dealer = new Dealer();
        dealer.receiveCard(Arrays.asList(new Card(3, Pattern.diamonds), new Card(9, Pattern.clubs), new Card(8, Pattern.diamonds)));

        BlackJackGame blackJackGame = new BlackJackGame(dealer, Arrays.asList(player1, player2));
        blackJackGame.result();
    }
}
