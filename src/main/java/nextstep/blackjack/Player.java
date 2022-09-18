package nextstep.blackjack;

import java.util.List;

public interface Player {
    void receiveCard(Card card);
    void receiveCard(List<Card> cardList);
    boolean hasCard(Card card);
    int calculateCardSum();
    String hasCardString();
    Boolean isBlackJack();
}
