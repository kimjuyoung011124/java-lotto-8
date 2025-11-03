package lotto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    void 여섯개_일치면_1등() {
        assertEquals(Rank.FIRST, Rank.of(6, false));
    }

    @Test
    void 다섯개_보너스일치면_2등() {
        assertEquals(Rank.SECOND, Rank.of(5, true));
    }

    @Test
    void 다섯개_보너스불일치면_3등() {
        assertEquals(Rank.THIRD, Rank.of(5, false));
    }

    @Test
    void 네개_일치면_4등() {
        assertEquals(Rank.FOURTH, Rank.of(4, false));
    }

    @Test
    void 세개_일치면_5등() {
        assertEquals(Rank.FIFTH, Rank.of(3, false));
    }

    @Test
    void 두개_이하면_NONE() {
        assertEquals(Rank.NONE, Rank.of(2, false));
    }
}
