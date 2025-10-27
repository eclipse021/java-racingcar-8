package racingcar.domain.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.model.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 자동차 경주에서 사용할 랜덤 값(0~9)을 생성하는 인터페이스
 */

public class ZeroToTenRandomFunc implements RandomFunc {

    private static final int MIN = 0;
    private static final int MAX = 9;

    /**
     * 0~9 사이의 정수를 생성
     */
    @Override
    public int randomValue() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }


    /**
     * 자동차 이름에 대해 랜덤값을 생성하여 Map으로 반환
     * key: 자동차 이름, value: 랜덤 값
     */
    @Override
    public Map<String, Integer> generatorRandomValuesByCars(List<Car> cars) {

        Map<String, Integer> randomMap = new HashMap<>();
        for (Car car : cars) {
            randomMap.put(car.getName(), randomValue());
        }
        return randomMap;

    }
}
