package racingcar.domain.model;

public class Car {

    private static final int MIN_REQUIREMENTS = 4;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private final CarStatus carStatus;

    public Car(String name) {
        validateName(name);
        this.name = name.trim();
        this.carStatus = new CarStatus();
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void moveForward(int randomValue) {
        if (randomValue < 0 || randomValue > 9) {
            throw new IllegalArgumentException("랜덤값은 0~9 사이여야 합니다.");
        }
        if (randomValue >= MIN_REQUIREMENTS) {
            carStatus.moveForward();
        }
    }

    public String getName() {
        return this.name;
    }

    public CarStatus getCarStatus() {
        return this.carStatus;
    }

}
