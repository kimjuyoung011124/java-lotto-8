package lotto;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {

    @Test
    void 당첨번호가_6개가_아니면_예외() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(nums, 7));
    }

    @Test
    void 당첨번호가_중복되면_예외() {
        List<Integer> nums = List.of(1, 2, 2, 4, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(nums, 7));
    }

    @Test
    void 보너스번호가_1에서_45범위밖이면_예외() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(nums, 50));
    }

    @Test
    void 보너스번호가_당첨번호와_중복되면_예외() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(nums, 6));
    }

    @Test
    void 정상입력시_객체_생성() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> new WinningNumbers(nums, 7));
    }
}
