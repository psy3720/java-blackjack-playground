package nextstep.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AbstractPlayer implements Player{
    List<Card> cardList;
    String name;
    int amount;

    public List<Card> getCardList() {
        return cardList;
    }

    public AbstractPlayer(String name) {
        this.cardList = new ArrayList<>();
        this.name = name;
        this.amount = 0;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public void receiveCard(Card card) {
        cardList.add(card);
    }

    @Override
    public void receiveCard(List<Card> card) {
        this.cardList = Stream
                .concat(this.cardList.stream()
                        , card.stream())
                .collect(Collectors.toList());
    }

    @Override
    public boolean hasCard(Card card) {
        return cardList.contains(card);
    }

    @Override
    public int calculateCardSum() {
        return cardList.stream()
                .mapToInt(card -> card.number)
                .sum();
    }

    @Override
    public String hasCardString() {
        return name + "카드: " + String.join(", ", cardList.stream()
                .map(card -> card.number + card.pattern.name)
                .collect(Collectors.toList()));
    }

    @Override
    public Boolean isBlackJack() {
        return calculateCardSum() == 21;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPlayer that = (AbstractPlayer) o;
        return amount == that.amount && Objects.equals(cardList, that.cardList) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardList, name, amount);
    }
}
