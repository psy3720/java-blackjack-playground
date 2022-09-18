package nextstep.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dealer {
    List<Card> cardList;
    String name;
    int amount;

    public Dealer() {
        this.name = "딜러";
        this.cardList = new ArrayList<>();
        amount = 0;
    }

    public void receiveCard(Card card) {
        cardList.add(card);
    }

    public void receiveCard(List<Card> card) {
        this.cardList = Stream.concat(this.cardList.stream(), card.stream()).collect(Collectors.toList());
    }

    public boolean hasCard(Card card) {
        return cardList.contains(card);
    }

    public int calculateCardSum() {
        return cardList.stream()
                .mapToInt(card -> card.number)
                .sum();
    }

    public String hasCardString() {
        return name + "카드: " + String.join(", ", cardList.stream()
                .map(card -> card.number + card.pattern.name)
                .collect(Collectors.toList()));
    }

    public Boolean isBlackJack() {
        return calculateCardSum() == 21;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dealer dealer = (Dealer) o;
        return Objects.equals(cardList, dealer.cardList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardList);
    }
}
