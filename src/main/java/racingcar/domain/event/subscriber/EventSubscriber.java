package racingcar.domain.event.subscriber;

public interface EventSubscriber {
    void onEvent(Object object);
}
