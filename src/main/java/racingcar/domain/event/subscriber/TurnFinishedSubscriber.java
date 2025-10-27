package racingcar.domain.event.subscriber;

import racingcar.domain.event.action.TurnFinishedAction;
import racingcar.domain.event.eventType.RaceFinishedEvent;
import racingcar.domain.event.eventType.TurnFinishedEvent;

import java.util.concurrent.Flow;

public class TurnFinishedSubscriber implements EventSubscriber {
    @Override
    public void onEvent(Object object) {

        if(!(object instanceof TurnFinishedEvent)) {
            throw new IllegalArgumentException("구독자가 잘못 선택되었습니다.");
        }

        TurnFinishedEvent turnFinishedEvent = (TurnFinishedEvent) object;
        TurnFinishedAction turnFinishedAction = new TurnFinishedAction(turnFinishedEvent);

        turnFinishedAction.action();
    }
}
