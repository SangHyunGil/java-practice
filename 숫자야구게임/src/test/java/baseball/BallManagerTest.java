package baseball;

import baseball.domain.BaseBall;
import baseball.baseballgame.Computer;
import org.junit.jupiter.api.Test;

public class BallManagerTest {

    @Test
    public void createGame() throws Exception {
        //given
        Computer computer = new Computer();
        //when
        BaseBall game =computer.createAnswerBall();
        System.out.println("answer = " + game);
        //then
    }
}
