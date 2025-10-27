package racingcar;

import racingcar.application.RacingCarController;
import racingcar.domain.event.publisher.EventPublisher;
import racingcar.domain.event.subscriber.RaceFinishedSubscriber;
import racingcar.domain.event.subscriber.TurnFinishedSubscriber;
import racingcar.domain.repository.RacingCarRepository;
import racingcar.domain.service.RacingCarService;
import racingcar.domain.service.ZeroToTenRandomFunc;
import racingcar.view.inputView.InputView;
import racingcar.view.outputView.RaceStartOutputView;

public class Application {
    public static void main(String[] args) {

        // 저장소, 랜덤함수 생성
        RacingCarRepository repository = new RacingCarRepository();
        ZeroToTenRandomFunc randomFunc = new ZeroToTenRandomFunc();

        // 이벤트 구독자 등록
        EventPublisher.subscribe(new TurnFinishedSubscriber(repository, randomFunc));
        EventPublisher.subscribe(new RaceFinishedSubscriber(repository));

        // 서비스, 뷰, 컨트롤러
        RacingCarService racingCarService = new RacingCarService(repository, randomFunc);
        InputView inputView = new InputView();

        RacingCarController controller =
                new RacingCarController(inputView, racingCarService);

        // 프로그램 실행
        controller.run();
    }
}
