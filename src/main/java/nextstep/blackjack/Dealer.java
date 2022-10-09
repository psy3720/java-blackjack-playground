package nextstep.blackjack;

public class Dealer extends Player {
    public Dealer() {
        super("딜러");
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }
}
