package racingcar.domain.repository;

import racingcar.domain.model.Car;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RacingCarRepository {

    // 자동차 전체 관리 목록
    private final Map<String, Car> cars = new LinkedHashMap<>();

    /**
     * 자동차를 저장소에 추가
     */
    public void addCar(String name) {

        if(cars.containsKey(name)) {
            throw new IllegalArgumentException("중복된 자동차 이름입니다: " + name);
        }

        // 자동차 생성 및 전체 관리 목록에 추가
        Car car = new Car(name);
        cars.put(car.getName(), car);
    }

    /**
     * 모든 자동차 목록 반환
     */
    public List<Car> findAll() {
        return new ArrayList<>(cars.values());
    }






}
