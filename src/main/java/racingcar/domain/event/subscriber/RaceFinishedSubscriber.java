package racingcar.domain.event.subscriber;

import racingcar.domain.event.action.RaceFinishedAction;
import racingcar.domain.event.eventType.RaceFinishedEvent;

import java.util.concurrent.Flow;

public class RaceFinishedSubscriber implements EventSubscriber {
    @Override
    public void onEvent(Object object) {

        RaceFinishedEvent raceFinishedEvent = (RaceFinishedEvent) object;
        RaceFinishedAction raceFinishedAction = new RaceFinishedAction();

    }
}
