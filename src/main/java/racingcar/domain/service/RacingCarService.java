package racingcar.domain.service;

import racingcar.domain.event.eventType.RaceFinishedEvent;
import racingcar.domain.event.eventType.TurnFinishedEvent;
import racingcar.domain.event.publisher.EventPublisher;
import racingcar.domain.model.Car;
import racingcar.domain.repository.RacingCarRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RacingCarService
 *
 * 레이스 전체 로직을 담당하는 서비스 클래스.
 * - 자동차 초기화
 * - 매 턴마다 랜덤 이동 처리
 * - 이벤트 발행 (TurnFinishedEvent, RaceFinishedEvent)
 */
public class RacingCarService {

    private final RacingCarRepository repository;
    private final ZeroToTenRandomFunc randomFunc;

    public RacingCarService(RacingCarRepository repository, ZeroToTenRandomFunc randomFunc) {
        this.repository = repository;
        this.randomFunc = randomFunc;
    }

    /** 자동차 등록 */
    public void registerCars(List<String> names) {
        for (String name : names) {
            repository.addCar(name);
        }
    }

    /** 전체 레이스 진행 */
    public void race(int turnCount) {
        for (int currentTurn = 1; currentTurn <= turnCount; currentTurn++) {
            playTurn();
        }
    }

    /** 최종 결과 계산 및 이벤트 발행 */
    public void finishRace() {
        EventPublisher.publish(new RaceFinishedEvent());
    }

    /** 한 턴 진행 */
    private void playTurn() {
        EventPublisher.publish(new TurnFinishedEvent());
    }
}