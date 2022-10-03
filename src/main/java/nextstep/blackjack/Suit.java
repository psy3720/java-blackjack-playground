package nextstep.blackjack;

public enum Suit {
    HEARTS("하트"),
    SPADES("스페이드"),
    CLUBS("클로버"),
    DIAMONDS("다이아몬드");

    String name;
    Suit(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
