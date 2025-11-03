package lotto;

import java.util.ArrayList;
import java.util.List;

final class Parser {
    private Parser() {}

    static List<Integer> parseIntsByComma(String line) {
        String[] tokens = line.split(",");
        List<Integer> nums = new ArrayList<>();
        for (String t : tokens) {
            nums.add(parseInt(t));
        }
        return nums;
    }

    static int parseInt(String s) {
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}
