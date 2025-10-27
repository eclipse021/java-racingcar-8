package racingcar.domain.event.eventType;

import java.util.List;

public class RaceFinishedEvent {

    private final List<String> winners;

    public RaceFinishedEvent(List<String> winners) {
        this.winners = winners;
    }

}
