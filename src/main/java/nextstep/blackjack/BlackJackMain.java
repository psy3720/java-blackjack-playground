package nextstep.blackjack;

public class BlackJackMain {
    public static void main(String[] args) {
        inputView inputView = new inputView();
        BlackJackGame blackJackGame = new BlackJackGame(inputView.input(inputView.inputParticipant()));
        blackJackGame.start();
    }
}
