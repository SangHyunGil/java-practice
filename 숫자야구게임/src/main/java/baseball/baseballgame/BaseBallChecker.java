package baseball.baseballgame;

import baseball.domain.BaseBall;
import baseball.domain.BaseBallType;

public class BaseBallChecker {

    public static BaseBallResult matchBall(BaseBall answer, BaseBall userInput) {
        BaseBallResult baseBallResult = new BaseBallResult();

        for (int idx = 0; idx < 3; idx++) {
            if (answer.isSamePosition(idx, userInput.getNumber(idx)))
                baseBallResult.addResult(BaseBallType.STRIKE);
            else if(answer.hasNumber(userInput.getNumber(idx))) {
                baseBallResult.addResult(BaseBallType.BALL);
            }
        }

        return baseBallResult;
    }
}
