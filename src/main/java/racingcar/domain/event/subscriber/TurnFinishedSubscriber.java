package racingcar.domain.event.subscriber;

import racingcar.domain.event.action.TurnFinishedAction;
import racingcar.domain.event.eventType.TurnFinishedEvent;

import java.util.concurrent.Flow;

public class TurnFinishedSubscriber implements EventSubscriber {
    @Override
    public void onEvent(Object object) {

        TurnFinishedEvent turnFinishedEvent = (TurnFinishedEvent) object;
        TurnFinishedAction turnFinishedAction = new TurnFinishedAction(turnFinishedEvent);

        turnFinishedAction.action();
    }
}
