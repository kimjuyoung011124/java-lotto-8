package lotto;

import java.util.List;
import java.util.Set;

final class Validator {
    private Validator() {}

    static void validateAmount(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다.");
        if (amount % 1000 != 0) throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    static void validateSixNumbers(List<Integer> nums) {
        if (nums.size() != 6) throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        long distinct = nums.stream().distinct().count();
        if (distinct != 6) throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        boolean outOfRange = nums.stream().anyMatch(n -> n < 1 || n > 45);
        if (outOfRange) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    static void validateBonus(int bonus, Set<Integer> mains) {
        if (bonus < 1 || bonus > 45) throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
        if (mains.contains(bonus)) throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}
