package nextstep.blackjack;

import java.util.List;

public class BlackJackMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<Participant> participantList = inputView.input(inputView.input());
        BlackJackGame game = new BlackJackGame();
        inputView.betAmountInput(participantList);
        game.setGame(participantList);
        game.init();
    }
}
