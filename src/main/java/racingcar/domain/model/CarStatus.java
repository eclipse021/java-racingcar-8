package racingcar.domain.model;

public class CarStatus {

    private int MovingCnt;              // 이동 횟수
    private String expression;    // '-' 표현

    public CarStatus() {
        this.MovingCnt = 0;
        this.expression = "";
    }

}
