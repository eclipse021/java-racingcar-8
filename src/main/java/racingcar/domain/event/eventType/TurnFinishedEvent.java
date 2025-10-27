package racingcar.domain.event.eventType;

import racingcar.domain.model.Car;

import java.util.Map;

public class TurnFinishedEvent {

    private final Map<String, Car> carMap;

    public TurnFinishedEvent(Map<String, Car> carMap) {
        this.carMap = carMap;
    }
}
