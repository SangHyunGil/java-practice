package baseball.domain;

import baseball.util.StringUtil;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseBallFactory {

    private static final int ANSWER_COUNT = 3;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;

    public static BaseBall createAnswerBall() {
        List<Integer> answerBall = getAnswerBall();
        return new BaseBall(answerBall);
    }

    private static List<Integer> getAnswerBall() {
        Set<Integer> answerBall = new HashSet<>();
        while (answerBall.size() < ANSWER_COUNT) {
            answerBall.add(Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER));
        }
        return new ArrayList<>(answerBall);
    }

    public static BaseBall createUserBall(String input) {
        return new BaseBall(StringUtil.split(input));
    }
}
