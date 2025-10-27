package racingcar.view.outputView;

import racingcar.domain.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RaceFinishedOutputView {

    public void printRacingFinishedOutput(List<Car> cars) {
        String result = cars.stream()
                .map(Car::getName)       // Car 객체 → 자동차 이름(String)
                .collect(Collectors.joining(", ")); // 쉼표로 구분해 하나의 문자열로 결합 ex) pob, jun

        System.out.println("최종 우승자 : " + result);
    }

}
