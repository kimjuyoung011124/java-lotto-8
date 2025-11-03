package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public final class NumberIssuer {

    public List<Integer> issueOne() {
        List<Integer> nums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(nums);           // 오름차순 정렬
        return nums;                      // 예: [1, 8, 14, 22, 33, 41]
    }
}
