package baseball.domain;

public enum BaseBallType {
    BALL("볼"), STRIKE("스트라이크");

    private String desc;

    BaseBallType(String desc) {
        this.desc = desc;
    }

    public String result(int result) {
        return result + desc;
    }
}
