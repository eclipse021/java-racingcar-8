package racingcar.view.inputView;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자 입력을 담당하는 클래스.
 *
 * - 자동차 이름 입력
 * - 시도 횟수 입력
 * - 입력값 검증
 */
public class InputView {

    private static final String NAME_DELIMITER = ",";

    /**
     * 경주할 자동차 이름을 입력받는다.
     * 이름은 쉼표(,) 기준으로 구분하며, 각 이름은 5자 이하이어야 한다.
     */
    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        if (input.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }

        List<String> names = Arrays.stream(input.split(NAME_DELIMITER))
                .collect(Collectors.toList());

        validateNames(names);

        return names;
    }

    /**
     * 시도 횟수를 입력받는다.
     */
    public int readAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        int count = validateAttemptCount(input);
        return count;
    }

    /**
     * 자동차 이름의 유효성 검사를 실행한다.
     */
    private static void validateNames(List<String> names) {
        // 이름 길이 검사
        boolean invalid = names.stream().anyMatch(name -> name.length() > 5 || name.isEmpty());
        if (invalid) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
        }
    }

    /**
     * 시도 횟수의 유효성 검사를 실행하다.
     */
    private static int validateAttemptCount(String input){
        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}