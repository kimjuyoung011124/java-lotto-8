package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        long distinct = numbers.stream().distinct().count();
        if (distinct != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
        boolean outOfRange = numbers.stream().anyMatch(n -> n < 1 || n > 45);
        if (outOfRange) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public List<Integer> numbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
