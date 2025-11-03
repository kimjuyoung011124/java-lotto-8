package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    private static final int PRICE = 1000;

    public static void main(String[] args) {
        int amount = readAmount();
        int count = amount / PRICE;
        System.out.println(count + "개를 구매했습니다.");
        printTickets(count);

        WinningNumbers winning = readWinningNumbers(); // step2 당첨/보너스입
        // TODO: Step 3에서 winning과 발행한 티켓들로 결과/수익률 계산
    }

    private static int readAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해주세요.");
                int amount = parseInt(Console.readLine());
                Validator.validateAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // [ERROR]로 시작
            }
        }
    }

    private static int parseInt(String s) {
        try { return Integer.parseInt(s.trim()); }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private static void printTickets(int count) {
        NumberIssuer issuer = new NumberIssuer();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = issuer.issueOne();
            System.out.println(numbers);
        }
    }
}
    private static WinningNumbers readWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                List<Integer> mains = Parser.parseIntsByComma(camp.nextstep.edu.missionutils.Console.readLine());
                Validator.validateSixNumbers(mains);

                int bonus = readBonus(mains);
                return new WinningNumbers(mains, bonus);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private static int readBonus(List<Integer> mains) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonus = Parser.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
                Validator.validateBonus(bonus, Set.copyOf(mains));
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
