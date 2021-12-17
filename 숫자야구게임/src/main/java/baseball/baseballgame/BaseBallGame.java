package baseball.baseballgame;

import baseball.domain.BaseBall;
import baseball.ui.OutputView;

public class BaseBallGame {

    private Computer computer = new Computer();
    private User user = new User();

    public void startGame() {
        BaseBall answerBall = computer.createAnswerBall();
        playBaseBall(answerBall);
    }

    private void playBaseBall(BaseBall answerBall) {
        OutputView.inputNumber();
        BaseBall userInput = user.createUserInput();

        BaseBallResult baseBallResult = BaseBallChecker.matchBall(answerBall, userInput);
        OutputView.result(baseBallResult.getResult());
        if (baseBallResult.isAnswer()) {
            OutputView.answer();
        } else {
            playBaseBall(answerBall);
        }
    }
}
