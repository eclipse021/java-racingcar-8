package racingcar.domain.event.subscriber;

import racingcar.domain.event.action.TurnFinishedAction;
import racingcar.domain.event.eventType.RaceFinishedEvent;
import racingcar.domain.event.eventType.TurnFinishedEvent;
import racingcar.domain.repository.RacingCarRepository;
import racingcar.domain.service.ZeroToTenRandomFunc;

import java.util.concurrent.Flow;

public class TurnFinishedSubscriber implements EventSubscriber {

    private final RacingCarRepository repository;
    private final ZeroToTenRandomFunc randomFunc;

    public TurnFinishedSubscriber(RacingCarRepository repository, ZeroToTenRandomFunc randomFunc) {
        this.repository = repository;
        this.randomFunc = randomFunc;
    }

    @Override
    public void onEvent(Object object) {
        if (!(object instanceof TurnFinishedEvent event)) {
            throw new IllegalArgumentException("TurnFinishedSubscriber는 TurnFinishedEvent만 처리합니다.");
        }

        TurnFinishedAction action = new TurnFinishedAction(event, repository, randomFunc);
        action.action();
    }
}
