package nextstep.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Player {
    int betAmount;
    String name;
    List<Card> cardList;

    public Player(String name) {
        this.name = name;
        this.cardList = new ArrayList<>();
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }

    public int getBetAmount() {
        return this.betAmount;
    }

    public void receiveCard(Card card) {
        cardList.add(card);
    }

    public void receiveCard(List<Card> card) {
        this.cardList = Stream.concat(this.cardList.stream(), card.stream()).collect(Collectors.toList());
    }

    public String hasCardString() {
        return name + "카드: " + String.join(", ", cardList.stream()
                .map(card -> card.number + card.pattern.name)
                .collect(Collectors.toList()));
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public int calculateCardSum() {
        return cardList.stream()
                .mapToInt(card -> card.number)
                .sum();
    }

    public Boolean isBlackJack() {
        return calculateCardSum() == 21;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return betAmount == player.betAmount && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(betAmount, name);
    }

    public boolean hasCard(Card card) {
        return cardList.contains(card);
    }
}
