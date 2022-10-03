package nextstep.blackjack;

import java.util.List;

public class ResultView {
    public void distributeTwoCardResult(List<Gamer> gamerList, Dealer dealer) {
        System.out.println(dealer.cardOpen());
        for(int i=0; i<gamerList.size(); i++) {
            Gamer gamer = gamerList.get(i);
            System.out.println(gamer.cardOpen());
        }
    }

    public void resultCard(Dealer dealer, List<Gamer> gamerList) {
        System.out.println(dealer.getName() + " 카드:" + dealer.cardOpen() + " - 결과:" + dealer.calcuateCardNumberTotal());

        for(int i=0; i< gamerList.size(); i++) {
            Gamer gamer = gamerList.get(i);
            System.out.println(gamer.getName() + " 카드:" + gamer.cardOpen() + " - 결과:"+ gamer.calcuateCardNumberTotal());
        }
    }

    public void resultAmount() {

    }
}
