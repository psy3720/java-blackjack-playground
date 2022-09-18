package nextstep.blackjack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Pattern {
    diamonds("다이아몬드"),
    clubs("클로버"),
    hearts("하트"),
    spades("스페이드");

    String name;

    Pattern(String name) {
        this.name = name;
    }

    public static Pattern random() {
        List<Pattern> collect = Arrays.stream(Pattern.values())
                .collect(Collectors.toList());
        Collections.shuffle(collect);

        return collect.get(0);
    }
}
