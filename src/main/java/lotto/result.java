package lotto;

import java.util.EnumMap;
import java.util.Map;

public final class Result {
    private final Map<Rank, Integer> counts = new EnumMap<>(Rank.class);

    public Result() {
        counts.put(Rank.FIRST, 0);
        counts.put(Rank.SECOND, 0);
        counts.put(Rank.THIRD, 0);
        counts.put(Rank.FOURTH, 0);
        counts.put(Rank.FIFTH, 0);
    }

    public void add(Rank rank) {
        if (rank == Rank.NONE) return;
        counts.put(rank, counts.get(rank) + 1);
    }

    public int count(Rank rank) { return counts.get(rank); }

    public long totalPrize() {
        long sum = 0;
        sum += (long) counts.get(Rank.FIFTH)  * Rank.FIFTH.prize();
        sum += (long) counts.get(Rank.FOURTH) * Rank.FOURTH.prize();
        sum += (long) counts.get(Rank.THIRD)  * Rank.THIRD.prize();
        sum += (long) counts.get(Rank.SECOND) * Rank.SECOND.prize();
        sum += (long) counts.get(Rank.FIRST)  * Rank.FIRST.prize();
        return sum;
    }
}
