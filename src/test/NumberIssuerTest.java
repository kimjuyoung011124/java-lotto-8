package lotto;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class NumberIssuerTest {

    @Test
    void 항상_6개의_숫자가_생성된다() {
        NumberIssuer issuer = new NumberIssuer();
        List<Integer> numbers = issuer.issueOne();
        assertEquals(6, numbers.size());
    }

    @Test
    void 생성된_숫자는_중복이_없다() {
        NumberIssuer issuer = new NumberIssuer();
        List<Integer> numbers = issuer.issueOne();
        long distinct = numbers.stream().distinct().count();
        assertEquals(6, distinct);
    }

    @Test
    void 생성된_숫자는_1에서_45사이다() {
        NumberIssuer issuer = new NumberIssuer();
        List<Integer> numbers = issuer.issueOne();
        assertTrue(numbers.stream().allMatch(n -> n >= 1 && n <= 45));
    }
}
