package racingcar.domain.event.eventType;

import racingcar.domain.model.Car;

import java.util.List;

public class RaceFinishedEvent {

    private final List<Car> cars;

    public RaceFinishedEvent(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

}
