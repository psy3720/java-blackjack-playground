package nextstep.blackjack;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static final String SEPARATOR = ",";
    Scanner sc = new Scanner(System.in);

    public String input() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return sc.next();
    }

    public List<Participant> input(String players) {
        validate(players);

        return Arrays.stream(players.split(SEPARATOR))
                .map(name -> new Participant(name))
                .collect(Collectors.toList());
    }

    private void validate(String players) {
        if (null == players || players.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void distributeTwoCards(List<Participant> participantList, Dealer dealer) {
        System.out.println("딜러와 "
                + String.join(", ", participantList.stream().map(player -> player.name)
                .collect(Collectors.toList()))
                + "에게 2장씩 나누었습니다."
        );
        System.out.println("딜러 카드: " + dealer.hasCardString());
    }

    public void betAmountInput(List<Participant> participantList) {
        participantList.stream()
                .forEach(player -> {
                    System.out.println(player.name + "의 배팅 금액은?");
                    Scanner sc = new Scanner(System.in);
                    int amount = sc.nextInt();
                    player.setAmount(amount);
                });
    }

    public void addCard(List<Participant> participantList) {
        participantList.stream()
                .forEach(player -> {
                    while (true) {
                        if (player.calculateCardSum() > 21) {
                            break;
                        }

                        System.out.println(player.name + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");

                        Scanner sc = new Scanner(System.in);
                        String next = sc.next();

                        if (next.equals("n")) {
                            break;
                        }

                        player.receiveCard(CardFactory.createCard());
                        System.out.println(player.hasCardString());
                    }
                });
    }

    public void result(Dealer dealer, List<Participant> participantList) {
        System.out.println(dealer.hasCardString() + " - 결과:" + dealer.calculateCardSum());

        for (Participant participant : participantList) {
            System.out.println(participant.hasCardString() + " - 결과:" + participant.calculateCardSum());
        }
    }

    public void resultAmount(List<Participant> participantList, Dealer dealer) {
        System.out.println("## 최종수익");
        System.out.println("딜러: " + dealer.getAmount());
        for (Participant participant : participantList) {
            System.out.println(participant.name + ": " + participant.getAmount());
        }
    }
}
