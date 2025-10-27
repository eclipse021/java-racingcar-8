package racingcar.domain.event.subscriber;

import racingcar.domain.event.action.RaceFinishedAction;
import racingcar.domain.event.eventType.RaceFinishedEvent;
import racingcar.domain.repository.RacingCarRepository;

import java.util.concurrent.Flow;

public class RaceFinishedSubscriber implements EventSubscriber {

    private final RacingCarRepository repository;

    public RaceFinishedSubscriber(RacingCarRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onEvent(Object object) {
        if (!(object instanceof RaceFinishedEvent event)) {
            throw new IllegalArgumentException("RaceFinishedSubscriber는 RaceFinishedEvent만 처리합니다.");
        }

        RaceFinishedAction action = new RaceFinishedAction(event, repository);
        action.action();
    }
}
