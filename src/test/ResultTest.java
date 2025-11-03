package lotto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void 등수별_카운트가_정상적으로_누적된다() {
        Result result = new Result();
        result.add(Rank.FIFTH);
        result.add(Rank.FIFTH);
        result.add(Rank.THIRD);

        assertEquals(2, result.count(Rank.FIFTH));
        assertEquals(1, result.count(Rank.THIRD));
        assertEquals(0, result.count(Rank.FIRST));
    }

    @Test
    void 총상금이_정확히_계산된다() {
        Result result = new Result();
        result.add(Rank.FIFTH);
        result.add(Rank.THIRD);
        result.add(Rank.FIRST);

        long expected = Rank.FIFTH.prize() + Rank.THIRD.prize() + Rank.FIRST.prize();
        assertEquals(expected, result.totalPrize());
    }

    @Test
    void NONE등수는_집계되지_않는다() {
        Result result = new Result();
        result.add(Rank.NONE);
        assertEquals(0, result.count(Rank.FIFTH));
        assertEquals(0, result.count(Rank.FIRST));
    }
}
