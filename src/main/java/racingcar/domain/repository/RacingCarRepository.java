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
     *  @param name : 자동차 이름
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


    /**
     * RandomFunc 에서 실행한 랜덤 결과(Map<String,Integer>)를 받아 이동시킨다.
     *
     * @param randomMap key: 자동차 이름, value: 랜덤값(0~9)
     */
    public void moveAll(Map<String, Integer> randomMap) {
        for (Map.Entry<String, Integer> entry : randomMap.entrySet()) {
            Car car = cars.get(entry.getKey());
            if (car != null) {
                car.moveForward(entry.getValue());
            }
        }
    }
    



}
