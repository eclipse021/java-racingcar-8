package racingcar.domain.event.action;

import racingcar.domain.event.eventType.RaceFinishedEvent;
import racingcar.domain.event.eventType.TurnFinishedEvent;
import racingcar.view.outputView.TurnFinishedOutputView;

public class TurnFinishedAction {

    private final TurnFinishedEvent turnFinishedEvent;

    public TurnFinishedAction(TurnFinishedEvent turnFinishedEvent) {
        this.turnFinishedEvent = turnFinishedEvent;
    }

    public void action() {
        TurnFinishedOutputView.printTurnFinishedOutput(turnFinishedEvent.getCarMap());
    }
}
