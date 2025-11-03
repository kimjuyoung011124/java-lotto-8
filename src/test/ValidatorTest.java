package lotto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void 금액이_0이하면_예외() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateAmount(0));
    }

    @Test
    void 금액이_1000단위가_아니면_예외() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateAmount(1500));
    }

    @Test
    void 금액이_정상이면_통과() {
        assertDoesNotThrow(() -> Validator.validateAmount(8000));
    }
}
