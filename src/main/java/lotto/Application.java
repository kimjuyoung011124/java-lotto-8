package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Application {
    private static final int PRICE = 1000;

    public static void main(String[] args) {
        int amount = readAmount();
        int count = amount / PRICE;
        System.out.println(count + "개를 구매했습니다.");
        printTickets(count);
        var tickets = issueTickets(count);          // 발행 목록 보관
        printTickets(tickets);

        WinningNumbers winning = readWinningNumbers(); // step2 당첨/보너스입력
        Result result = evaluate(tickets, winning); // step3 평가 > 출력
        printStatistics(result, amount);
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

    private static void printTickets(java.util.List<java.util.List<Integer>> tickets) {
        for (var numbers : tickets) System.out.println(numbers);
    } //printTickets(int count) 대신 목록 출력으로 교

    
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
    private static java.util.List<java.util.List<Integer>> issueTickets(int count) {
        NumberIssuer issuer = new NumberIssuer();
        var tickets = new ArrayList<java.util.List<Integer>>();
        for (int i = 0; i < count; i++) tickets.add(issuer.issueOne());
        return tickets;
    }

    private static Result evaluate(java.util.List<java.util.List<Integer>> tickets, WinningNumbers winning) {
        Result result = new Result();
        Set<Integer> mains = winning.mains();
        int bonus = winning.bonus();

        for (var t : tickets) {
            int match = countMatch(t, mains);
            boolean bonusMatched = t.contains(bonus);
            result.add(Rank.of(match, bonusMatched));
        }
        return result;
    }
    private static int countMatch(java.util.List<Integer> ticket, Set<Integer> mains) {
        int cnt = 0;
        for (int n : ticket) if (mains.contains(n)) cnt++;
        return cnt;
    }

    private static void printStatistics(Result r, int amount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + r.count(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + r.count(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + r.count(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + r.count(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + r.count(Rank.FIRST) + "개");

        long prize = r.totalPrize();
        BigDecimal yield = BigDecimal.valueOf(prize)
                .divide(BigDecimal.valueOf(amount), 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(1, RoundingMode.HALF_UP);
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

