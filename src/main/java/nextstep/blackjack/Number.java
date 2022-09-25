package nextstep.blackjack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Number {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10);

    int number;

    Number(int number) {
        this.number = number;
    }

    public static Number random() {
        List<Number> collect = Arrays.stream(Number.values())
                .collect(Collectors.toList());

        Collections.shuffle(collect);

        return collect.get(0);
    }
}
