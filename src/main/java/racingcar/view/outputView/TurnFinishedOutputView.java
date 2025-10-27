package racingcar.view.outputView;

import racingcar.domain.model.Car;

import java.util.Map;

public class TurnFinishedOutputView {

    public static void printTurnFinishedOutput(Map<String, Car> carMap) {
        carMap.forEach((name, car) -> {
            System.out.println(car.getName() + " : " + car.getCarStatus().getExpression());
        });
    }

}
