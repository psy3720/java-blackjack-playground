package nextstep.blackjack;

public enum Denomination {
    ACE(1, "A"),
    TWO(2, ""),
    THREE(3, ""),
    FOUR(4, ""),
    FIVE(5, ""),
    SIX(6, ""),
    SEVEN(7, ""),
    EIGHT(8, ""),
    NINE(9, ""),
    JACK(10, "J"),
    KING(10, "K"),
    QUEEN(10, "Q");

    int number;
    String name;

    Denomination(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public boolean isAce() {
        return this == ACE;
    }

    public String getName() {
        return this.name;
    }
}
