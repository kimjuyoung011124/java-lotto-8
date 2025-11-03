package lotto;

import java.util.List;
import java.util.Set;

final class WinningNumbers {
    private final Set<Integer> mains; // 당첨 6개
    private final int bonus;

    WinningNumbers(List<Integer> mains, int bonus) {
        Validator.validateSixNumbers(mains);
        this.mains = Set.copyOf(mains);
        Validator.validateBonus(bonus, this.mains);
        this.bonus = bonus;
    }

    Set<Integer> mains() { return mains; }
    int bonus() { return bonus; }
}
