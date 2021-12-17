package baseball.baseballgame;

import baseball.domain.BaseBall;
import baseball.domain.BaseBallFactory;

public class Computer {
    public BaseBall createAnswerBall() {
        return BaseBallFactory.createAnswerBall();
    }
}
