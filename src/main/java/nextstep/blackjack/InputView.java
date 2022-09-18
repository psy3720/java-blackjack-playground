package nextstep.blackjack;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final String SEPARATOR = ",";

    public List<Player> input(String players) {
        return Arrays.stream(players.split(SEPARATOR))
                .map(name -> new Player(name))
                .collect(Collectors.toList());
    }

    public void distributeTwoCards(List<Player> playerList) {
        System.out.println("딜러와 "
                + String.join(", " , playerList.stream().map(player -> player.name).collect(Collectors.toList()))
                + "에게 2장씩 나누었습니다."
        );

        playerList.stream()
                .forEach(player -> {
                    player.receiveCard(Arrays.asList(CardFactory.createCard(), CardFactory.createCard()));
                    System.out.println(player.hasCardString());
                });
    }

    public void betAmountInput(List<Player> playerList) {
        playerList.stream()
                .forEach(player -> {
                    System.out.println(player.name + "의 배팅 금액은?");
                    Scanner sc = new Scanner(System.in);
//                    int amount = sc.nextInt();
                    int amount = 10000;
                    player.setBetAmount(amount);
                });
    }

    public void addCard(List<Player> playerList) {
        playerList.stream()
                .forEach(player -> {
                    while(true) {
                        System.out.println(player.name + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");

                        Scanner sc = new Scanner(System.in);
                        String next = sc.next();

                        if(next.equals("n")) {
                            break;
                        }

                        player.receiveCard(CardFactory.createCard());
                        System.out.println(player.hasCardString());
                    }
                });
    }

    public void result(Dealer dealer, List<Player> playerList) {
        System.out.println(dealer.hasCardString() + " - 결과:" + dealer.calculateCardSum() ) ;

        for (Player player : playerList) {
            System.out.println(player.hasCardString() + " - 결과:" +  player.calculateCardSum());
        }

        System.out.println("## 최종수익");

    }
}
