package nextstep.blackjack;

import java.util.Comparator;
import java.util.List;

public class BlackJackGame {
    private Dealer dealer;
    private List<Player> playerList;
    private InputView inputView;

    public BlackJackGame() {
    }

    public BlackJackGame(Dealer dealer, List<Player> playerList) {
        this.dealer = dealer;
        this.playerList = playerList;
    }

    public void init(List<Player> playerList) {
        this.dealer = new Dealer();
        this.playerList = playerList;
        inputView = new InputView();

        inputView.distributeTwoCards(playerList);
        inputView.addCard(playerList);
        this.checkDealer();
        inputView.result(dealer, playerList);
    }

    private void checkDealer() {
        while(dealer.calculateCardSum() <= 16) {
            dealer.receiveCard(CardFactory.createCard());
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
        }
    }

    public void result() {
        int totalBetAmount = 0;

        for (Player player : playerList) {
            totalBetAmount += player.betAmount;
        }

        /* 딜러가 21을 초과하는 경우 0 */
        if(dealer.calculateCardSum() > 21) {
            return;
        }

        Player winner = playerList.stream()
                .filter(player1 -> player1.calculateCardSum() <= 21)
                .max(Comparator.comparing(Player::calculateCardSum))
                .get();


        for (Player player1 : playerList) {
            if(!winner.equals(player1)) {
//                totalBetAmount += player1.betAmount;
                player1.setBetAmount(player1.getBetAmount() * -1);
            }
        }

        int betAmount = winner.getBetAmount();

        if(winner.isBlackJack()) {
            if(!dealer.isBlackJack()) {
                winner.setBetAmount(betAmount);
            }
        }
        totalBetAmount -= betAmount;
        dealer.amount = totalBetAmount;

        System.out.println("dealer = " + dealer.amount);
        for (Player player1 : playerList) {
            System.out.println("player = " + player1.name + "," + player1.betAmount);
        }
    }

}
