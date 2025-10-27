package racingcar.domain.event.action;

import racingcar.domain.event.eventType.RaceFinishedEvent;
import racingcar.view.outputView.RaceFinishedOutputView;

public class RaceFinishedAction {

    private final RaceFinishedEvent raceFinishedEvent;

    public RaceFinishedAction(RaceFinishedEvent raceFinishedEvent ) {
        this.raceFinishedEvent = raceFinishedEvent;
    }

    public void action() {
       RaceFinishedOutputView.printRacingFinishedOutput(raceFinishedEvent.getCars());
    }

}
