package racingcar.domain.model;

public class CarStatus {

    private int movingCnt;              // 이동 횟수
    private String expression;    // '-' 표현

    public CarStatus() {
        this.movingCnt = 0;
        this.expression = "";
    }

    public void moveForward() {
        this.movingCnt++;
        this.expression += "-";
    }

}
