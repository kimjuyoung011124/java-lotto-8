package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public final class NumberIssuer {
    public Lotto issueOne() {
        List<Integer> nums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(nums);                  
        return new Lotto(nums);                  
    }
}
