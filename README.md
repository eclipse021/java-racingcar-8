# java-racingcar-precourse


## ⚙️ 기능 목록 단위
### 🧩 입력 및 검증

1. 사용자로부터 경주할 자동차 이름을 쉼표(,) 기준으로 입력받는다.

2. 각 자동차 이름은 5자 이하이어야 한다. 
   - 이름이 공백이거나 중복된 경우 또한 예외 발생

3. 시도 횟수를 입력받는다.
   - 음수 또는 0일 경우 IllegalArgumentException 발생
   - 숫자가 아닌 입력일 경우 예외 발생

### 🏁 경주 로직

1. 입력받은 자동차 이름에 따른 자동차 객체(Car)를 생성한다.

2. 각 자동차는 내부적으로 이름과 이동 거리(CarStatus)를 가진다.

3. 지정된 시도 횟수만큼 반복하며, 매 턴마다 다음 과정을 수행한다.

   - RandomFunc을 통해 각 자동차별 랜덤값(0~9)을 생성한다.
   - 랜덤값이 4 이상인 경우 해당 자동차의 위치를 1 증가시킨다.
   - 모든 자동차 이름과 이동 거리를 화면에 출력한다.
   - 모든 시도 횟수 종료 후 가장 많이 전진한 자동차를 우승자로 출력한다. (공동 우승 가능)

## 🎨 설계 패턴

본 과제는 MVC 아키텍처를 기반으로,
DDD(도메인 주도 설계) 와 SRP(단일 책임 원칙) 을 준수하며 계층별 책임을 분리하였다.
또한, 각 단계 간 결합도를 낮추기 위해 이벤트 아키텍처(Event-Driven Architecture) 를 도입하였다.


## 주요 컴포넌트 설명

### RacingCarRepository
- 자동차(Car) 객체들을 관리하는 저장소
- Map<String, Car> 구조로 자동차 이름과 상태를 관리
- 매 턴 이동(moveAll) 처리 및 상태 일관성(verifyConsistencyByCars) 검증 담당

### EventPublisher / Subscriber / Action

- Publisher는 발생한 이벤트를 모든 Subscriber에게 전달

- Subscriber는 특정 이벤트 타입을 구독하고, 대응되는 Action을 실행하여 실제 비즈니스 로직(출력, 검증 등)을 처리
   - 예:
      - TurnFinishedEvent → TurnFinishedSubscriber → TurnFinishedAction

      - RaceFinishedEvent → RaceFinishedSubscriber → RaceFinishedAction


### 고려 사항

#### 1. 이벤트 아키텍처 선택과 그 이유:
각 자동차의 실행순서가 절대적이지 않고, 병렬적으로 처리 가능한 구조라
이벤트 기반 비동기 모델과 잘 맞는다고 생각했습니다.
따라서 책임 분리를 적극적으로 실행하고 유지보수를 위해 해당 아키텍처를 도입했습니다.

#### 2. 성능 고려:
매 턴마다 "-" 문자열을 반복적으로 생성하면 시간 복잡도가 커지기 때문에,
CarStatus에서 현재 이동 횟수(movingCnt)와 표현(expression)을 함께 관리하도록 했다.
이중화된 값은 매 턴 검증(verifyConsistencyByCars)을 통해 동기화 문제를 조기에 탐지한다.

#### 3. 확장성
현재 구조는 비동기 이벤트 큐나 스레드 풀을 붙이기 용이합니다.
따라서 도전 과제로는 이벤트 비동기화 및 병렬 실행 구현을 고려중입니다.