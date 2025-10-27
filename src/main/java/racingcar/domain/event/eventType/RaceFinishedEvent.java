package racingcar.domain.event.eventType;

import racingcar.domain.model.Car;

import java.util.List;


/**
 * 전체 레이스가 종료되었음을 알리는 이벤트.
 *
 * 데이터(List<Car>)는 Action에서 Repository에서 직접 조회.
 */
public class RaceFinishedEvent {

    public RaceFinishedEvent() {
        // 단순 신호용
    }
}
