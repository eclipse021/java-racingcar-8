package racingcar.domain.event.action;

import racingcar.domain.event.eventType.RaceFinishedEvent;
import racingcar.domain.event.eventType.TurnFinishedEvent;
import racingcar.domain.repository.RacingCarRepository;
import racingcar.domain.service.ZeroToTenRandomFunc;
import racingcar.view.outputView.TurnFinishedOutputView;

import java.util.HashMap;
import java.util.Map;

public class TurnFinishedAction {

    private final TurnFinishedEvent turnFinishedEvent;
    private final RacingCarRepository repository;
    private final ZeroToTenRandomFunc randomFunc;

    public TurnFinishedAction(
            TurnFinishedEvent turnFinishedEvent,
            RacingCarRepository repository,
            ZeroToTenRandomFunc randomFunc
    ) {
        this.turnFinishedEvent = turnFinishedEvent;
        this.repository = repository;
        this.randomFunc = randomFunc;
    }

    public void action() {
        // 자동차 전체 랜덤값 생성
        Map<String, Integer> randomMap = randomFunc.generatorRandomValuesByCars(repository.findAll());

        // 이동 처리
        repository.moveAll(randomMap);

        // 일관성 검증
        repository.verifyConsistencyByCars(repository.findAll());

        // 현재 턴 결과 구성
        Map<String, Integer> carPositions = new HashMap<>();
        repository.findAll().forEach(car ->
                carPositions.put(car.getName(), car.getCarStatus().getMovingCnt())
        );

        // 출력
        TurnFinishedOutputView.printTurnFinishedOutput(repository.getCars());
        System.out.println();

    }
}
