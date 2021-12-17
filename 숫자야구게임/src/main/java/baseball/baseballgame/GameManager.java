package baseball.baseballgame;

import baseball.ui.InputView;
import baseball.ui.OutputView;
import baseball.util.StringUtil;

public class GameManager {
    private static final int RESTART_GAME = 1;
    private final BaseBallGame game;

    public GameManager(BaseBallGame game) {
        this.game = game;
    }

    public void startGame() {
        game.startGame();
        askToRestartGame();
    }

    private void askToRestartGame() {
        OutputView.askRestart();
        if (StringUtil.toInt(InputView.input()) == RESTART_GAME) {
            startGame();
        }
    }
}
