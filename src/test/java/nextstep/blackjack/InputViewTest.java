package nextstep.blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InputViewTest {
    @Test
    void 게임참가자_입력() {
        inputView inputView = new inputView();
        List<Gamer> input = inputView.input("pobi,jason");
        Assertions.assertThat(input).contains(new Gamer("pobi"), new Gamer("jason"));
    }
}
