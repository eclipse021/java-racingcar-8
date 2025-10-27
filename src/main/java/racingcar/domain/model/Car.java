package racingcar.domain.model;

public class Car {

    private final String name;
    private final CarStatus carStatus;

    public Car(String name) {
        this.name = name.trim();
        this.carStatus = new CarStatus();
    }


}
