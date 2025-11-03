package lotto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    void 일치개수_6개면_1등() {
        assertEquals(Rank.FIRST, Rank.of(6, false));
    }

    @Test
    void 일치개수_5개_보너스_있으면_2등() {
        assertEquals(Rank.SECOND, Rank.of(5, true));
    }

    @Test
    void 일치개수_5개_보너스_없으면_3등() {
        assertEquals(Rank.THIRD, Rank.of(5, false));
    }
}
