package racingcar.domain.event.eventType;

import java.util.List;

public class RaceFinishedEvent {

    private final List<String> cars;

    public RaceFinishedEvent(List<String> cars) {
        this.cars = cars;
    }

}
