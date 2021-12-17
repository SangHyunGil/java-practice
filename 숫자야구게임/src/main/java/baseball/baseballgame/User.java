package baseball.baseballgame;

import baseball.domain.BaseBall;
import baseball.domain.BaseBallFactory;
import baseball.ui.InputView;

public class User {
    public BaseBall createUserInput() {
        return BaseBallFactory.createUserBall(InputView.input());
    }
}
