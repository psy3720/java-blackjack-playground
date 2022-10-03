package nextstep.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class inputView {
    private final String DELIMITER = ",";
    Scanner sc = new Scanner(System.in);

    public String reDistributeCard(Gamer gamer) {
        System.out.println(gamer.getName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        String next = sc.next();
        validate(next);
        return next;
    }

    private void validate(String next) {
        if(null == next || next.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if(!next.equals("y") && !next.equals("n")) {
            throw new IllegalArgumentException();
        }
    }

    public String inputParticipant() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String participant = sc.next();
        return participant;
    }

    public List<Gamer> input(String participant) {
        String[] participantArr = participant.split(DELIMITER);
        List<Gamer> gamerList = new ArrayList<>();

        for(int i=0; i< participantArr.length; i++) {
            System.out.println(participantArr[i] + "의 배팅 금액은?");
//            int amount = sc.nextInt();
            int amount = 0;
            gamerList.add(new Gamer(participantArr[i], amount));
        }

        return gamerList;
    }
}
