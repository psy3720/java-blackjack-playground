package nextstep.blackjack;

import java.util.List;

public class BlackJackGame {
    List<Gamer> gamerList;
    Dealer dealer;
    PlayingCard playingCard;
    ResultView resultView;
    inputView inputView;

    public BlackJackGame(List<Gamer> gamerList) {
        this.gamerList = gamerList;
        dealer = new Dealer();
        playingCard = new PlayingCard();
        resultView = new ResultView();
        inputView = new inputView();
    }

    public void start() {
        cardDistributeTwoCard();
        resultView.distributeTwoCardResult(gamerList, dealer);
        reDistributeCard();
        dealerDistributeCard();
        result();
    }

    private void result() {
        resultView.resultCard(dealer, gamerList);
        calculateAmount();
        resultView.resultAmount();
    }

    private void calculateAmount() {

    }

    private void dealerDistributeCard() {
        if(dealer.calcuateCardNumberTotal() <= 16) {
            dealer.receiveCard(playingCard.draw());
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
        }
    }

    private void reDistributeCard() {
        for(int i=0; i< gamerList.size(); i++) {
            cardDraw(gamerList.get(i));
        }
    }

    private void cardDraw(Gamer gamer) {
        while(gamer.calcuateCardNumberTotal() < 22) {
            String answer = inputView.reDistributeCard(gamer);
            if (answer.equals("n")) {
                break;
            }
            gamer.receiveCard(playingCard.draw());
            System.out.println(gamer.cardOpen());
        }
    }

    private void cardDistributeTwoCard() {
        for(int i=0; i<gamerList.size(); i++) {
            Gamer gamer = gamerList.get(i);
            gamer.receiveCard(playingCard.draw(2));
        }
        dealer.receiveCard(playingCard.draw(2));
    }
}
