package racingcar.domain.event.eventType;

import racingcar.domain.model.Car;

import java.util.Map;

/**
 * 한 턴이 종료되었음을 알리는 이벤트.
 *
 * 데이터(Map<String, Car>)를 들고 있지 않음.
 * 실제 이동 및 출력은 Action에서 Repository를 참조해 처리.
 */
public class TurnFinishedEvent {

    public TurnFinishedEvent() {
        // 단순 신호용
    }
}
