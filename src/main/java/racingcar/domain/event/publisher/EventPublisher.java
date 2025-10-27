package racingcar.domain.event.publisher;

import racingcar.domain.event.eventType.RaceFinishedEvent;
import racingcar.domain.event.eventType.TurnFinishedEvent;
import racingcar.domain.event.subscriber.EventSubscriber;
import racingcar.domain.event.subscriber.RaceFinishedSubscriber;
import racingcar.domain.event.subscriber.TurnFinishedSubscriber;

import java.util.ArrayList;
import java.util.List;

public class EventPublisher {

    // Publisher가 관리하는 모든 구독자 목록
    private static final List<EventSubscriber> subscribers = new ArrayList<>();

    /** 구독자 등록 */
    public static void subscribe(EventSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    /** 이벤트 발행 */
    public static void publish(Object event) {
        for (EventSubscriber subscriber : subscribers) {

            if(event instanceof TurnFinishedEvent){
                TurnFinishedSubscriber turnFinishedSubscriber = (TurnFinishedSubscriber) subscriber;
                turnFinishedSubscriber.onEvent(event);
            }

            if(event instanceof RaceFinishedEvent){
                RaceFinishedSubscriber raceFinishedSubscriber = (RaceFinishedSubscriber) subscriber;
                raceFinishedSubscriber.onEvent(event);
            }

        }
    }

}
