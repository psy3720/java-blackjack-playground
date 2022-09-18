package nextstep.blackjack;

import java.util.List;

public class BlackJackMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<Player> playerList = inputView.input("pobi,jason");
        BlackJackGame game = new BlackJackGame();
        inputView.betAmountInput(playerList);

        game.init(playerList);
    }
}
