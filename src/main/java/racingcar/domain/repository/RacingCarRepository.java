package racingcar.domain.repository;

import racingcar.domain.model.Car;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RacingCarRepository {

    // 자동차 전체 관리 목록
    private final Map<String, Car> cars = new LinkedHashMap<>();

    public Map<String, Car>getCars() {
        return cars;
    }

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

    /**
     * CarStatus의 movingCnt와 expression.length() 일치하는지 일관성을 검증한다
     * 만약, 둘이 일치하지 않으면 동기화 관련 문제가 발생했다고 판단해 예외 발생
     */
    public void verifyConsistencyByCars(List<Car> cars) {
        for (Car car : cars) {
            if(!car.getCarStatus().verifyConsistency()){
                throw new IllegalArgumentException("동기화 문제가 발생했습니다");
            }
        }
    }

    /**
     * 가장 많이 움직이는 자동차들을 찾아 리스트로 반환한다.
     */
    public List<Car> findTopMovingCars(){
        if(cars.isEmpty()) {
            return List.of();
        }

        int max = 0;

        for(Car car : cars.values()) {
            if(car.getCarStatus().getMovingCnt() >= max) {
                max = car.getCarStatus().getMovingCnt();
            }
        }

        List<Car> winners = new ArrayList<>();

        for(Car car : cars.values()) {
            if(car.getCarStatus().getMovingCnt() == max) {
                winners.add(car);
            }
        }

        return winners;
    }

}
