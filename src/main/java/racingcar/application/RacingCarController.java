package racingcar.application;

import racingcar.domain.service.RacingCarService;
import racingcar.view.inputView.InputView;
import racingcar.view.outputView.RaceStartOutputView;

import java.util.List;

/**
 * RacingCarController
 *
 * 사용자 입력을 받고 RacingCarService를 이용해 레이스를 실행한다.
 */
public class RacingCarController {

    private final InputView inputView;
    private final RacingCarService racingCarService;

    public RacingCarController(
            InputView inputView,
            RacingCarService racingCarService
    ) {
        this.inputView = inputView;
        this.racingCarService = racingCarService;
    }

    /** 전체 레이스 실행 */
    public void run() {

            // 사용자 입력
            List<String> names = inputView.readCarNames();
            int attemptCount = inputView.readAttemptCount();

            // 경주 시작 안내 출력
            RaceStartOutputView.printRaceStartOutput();

            // 자동차 등록
            racingCarService.registerCars(names);

            // 레이스 진행
            racingCarService.race(attemptCount);

            // 종료 처리
            racingCarService.finishRace();


    }
}

