package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseBall {
    private final List<Integer> baseBall;

    public BaseBall(List<Integer> balls) {
        validateSize(balls);
        validateDuplicate(balls);
        baseBall = balls;
    }

    private void validateSize(List<Integer> balls) {
        if (balls.size() != 3)
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요.");
    }

    private void validateDuplicate(List<Integer> balls) {
        Set<Integer> nonDuplicateBalls = new HashSet<>(balls);
        if (nonDuplicateBalls.size() != 3)
            throw new IllegalArgumentException("공의 숫자는 중복될 수 없습니다.");
    }

    public int getNumber(int index) {
        return baseBall.get(index);
    }

    public Boolean isSamePosition(int index, int number) {
        return this.baseBall.get(index) == number;
    }

    public Boolean hasNumber(int number) {
        return baseBall.contains(number);
    }
}
