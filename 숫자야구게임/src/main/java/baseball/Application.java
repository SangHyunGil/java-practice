package baseball;

import baseball.baseballgame.GameManager;
import baseball.baseballgame.BaseBallGame;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        GameManager gameManager = new GameManager(new BaseBallGame());
        gameManager.startGame();
    }
}
