package racingcar.domain.service;


import racingcar.domain.model.Car;

import java.util.List;
import java.util.Map;

/**
 * 랜덤 값을 생성하는 인터페이스
 */
public interface RandomFunc {

    int randomValue();

    Map<String, Integer> generatorRandomValuesByCars(List<Car> cars);


}
