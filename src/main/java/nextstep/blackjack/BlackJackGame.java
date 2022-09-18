package nextstep.blackjack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BlackJackGame {
    private Dealer dealer;
    private List<Participant> participantList;
    private InputView inputView;

    public BlackJackGame() {
        this.dealer = new Dealer();
        inputView = new InputView();
    }

    // test
    public BlackJackGame(Dealer dealer, List<Participant> participantList) {
        this.dealer = dealer;
        this.participantList = participantList;
    }

    public void setGame(List<Participant> participantList) {
        this.participantList = participantList;
    }

    public void init() {
        this.distributeTwoCards();
        this.checkDealer();
        this.result();
    }

    private void distributeTwoCards() {
        participantList.stream()
                .forEach(player -> {
                    player.receiveCard(Arrays.asList(CardFactory.createCard(), CardFactory.createCard()));
                    System.out.println(player.hasCardString());
                });

        dealer.receiveCard(Arrays.asList(CardFactory.createCard(), CardFactory.createCard()));

        inputView.distributeTwoCards(participantList, dealer);
        inputView.addCard(participantList);
    }

    private void checkDealer() {
        if(dealer.calculateCardSum() <= 16) {
            dealer.receiveCard(CardFactory.createCard());
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
        }
    }

    public void result() {
        inputView.result(dealer, participantList);

        if(dealer.calculateCardSum() > 21) {
            return;
        }

        int totalBetAmount = 0;
        Participant winner = participantList.stream()
                .filter(player1 -> player1.calculateCardSum() <= 21)
                .max(Comparator.comparing(Participant::calculateCardSum))
                .get();

        for (Participant participant1 : participantList) {
            if(!winner.equals(participant1)) {
                totalBetAmount += participant1.getAmount();
                participant1.setAmount(participant1.getAmount() * -1);
            }
        }

        int betAmount = winner.getAmount();
        totalBetAmount -= betAmount;
        dealer.amount = totalBetAmount;

        inputView.resultAmount(participantList, dealer);
    }
}
