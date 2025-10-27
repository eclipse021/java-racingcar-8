package racingcar.domain.event.action;

import racingcar.domain.event.eventType.RaceFinishedEvent;
import racingcar.domain.model.Car;
import racingcar.domain.repository.RacingCarRepository;
import racingcar.view.outputView.RaceFinishedOutputView;

import java.util.List;

public class RaceFinishedAction {

    private final RaceFinishedEvent raceFinishedEvent;
    private final RacingCarRepository repository;

    public RaceFinishedAction(RaceFinishedEvent raceFinishedEvent, RacingCarRepository repository) {
        this.raceFinishedEvent = raceFinishedEvent;
        this.repository = repository;
    }

    public void action() {
        // 우승자 찾기
        List<Car> winners = repository.findTopMovingCars();

        // 우승자 출력
        RaceFinishedOutputView.printRacingFinishedOutput(winners);
    }
}
