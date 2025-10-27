package racingcar.domain.event.subscriber;

import racingcar.domain.event.action.RaceFinishedAction;
import racingcar.domain.event.eventType.RaceFinishedEvent;

import java.util.concurrent.Flow;

public class RaceFinishedSubscriber implements EventSubscriber {
    @Override
    public void onEvent(Object object) {

        if(!(object instanceof RaceFinishedEvent)) {
            throw new IllegalArgumentException("구독자가 잘못 선택되었습니다.");
        }

        RaceFinishedEvent raceFinishedEvent = (RaceFinishedEvent) object;
        RaceFinishedAction raceFinishedAction = new RaceFinishedAction(raceFinishedEvent);

        raceFinishedAction.action();

    }
}
