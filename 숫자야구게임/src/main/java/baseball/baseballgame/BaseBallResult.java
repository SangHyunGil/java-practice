package baseball.baseballgame;

import baseball.domain.BaseBallType;

import java.util.*;
import java.util.stream.Collectors;

public class BaseBallResult {
    private static final int ANSWER_COUNT = 3;
    private static final int ZERO = 0;
    private static final String NOTHING = "낫싱";
    private final Map<BaseBallType, Integer> result = new HashMap<>();

    public void addResult(BaseBallType baseBallType) {
        result.put(baseBallType, result.getOrDefault(baseBallType, ZERO) + 1);
    }

    public String getResult() {
        if (istNothing()) {
            return NOTHING;
        }

        return result();
    }

    private boolean istNothing() {
        return result.isEmpty();
    }

    private String result() {
        return result.keySet()
                .stream()
                .sorted()
                .map(baseBallType -> baseBallType.result(count(baseBallType)))
                .collect(Collectors.joining(" "));
    }

    private int count(BaseBallType baseBallType) {
        if (!result.containsKey(baseBallType)) {
            return ZERO;
        }
        return result.get(baseBallType);
    }

    public Boolean isAnswer() {
        return result.containsKey(BaseBallType.STRIKE) && result.get(BaseBallType.STRIKE) == ANSWER_COUNT;
    }
}
