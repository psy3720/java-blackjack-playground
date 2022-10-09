package nextstep.blackjack;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Cards {
    private List<Card> cards;

    public Cards() {
        cards = new ArrayList<>();
    }

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public boolean contains(Card card) {
        return cards.contains(card);
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void add(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public int totalNumber() {
        int result = 0;

        // 에이스 존재 여부
        boolean isAce = cards.stream().anyMatch(card -> card.getDenomination().isAce());

        int aceExceptSum = cards.stream()
                .filter(card -> !card.getDenomination().isAce())
                .mapToInt(card -> card.getDenomination().number)
                .sum();
        if(isAce) {
            if(aceExceptSum <= 10) {
                result += 11;
            } else {
                result += 1;
            }
        }

        result += aceExceptSum;

        return result;
    }

    public int size() {
        return cards.size();
    }

    @Override
    public String toString() {
        String result = "";

        for(int i=0; i<cards.size(); i++) {
            result += cards.get(i).toString() + ",";
        }
        return result.substring(0, result.length() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cards cards1 = (Cards) o;
        return Objects.equals(cards, cards1.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }

    public Optional<Card> getRandomCard() {
        Collections.shuffle(cards);
        Card card = null;

        if(cards.size() > 0) {
            card = cards.get(0);
            cards.remove(0);
        }
        return Optional.of(card);
    }
}
