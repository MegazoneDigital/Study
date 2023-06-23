package mz.academy.event;

import mz.common.domain.event.AccountRegisteredEvent;

public interface EventProducer {

    void produceAccountRegisteredEvent(AccountRegisteredEvent accountRegisteredEvent);
}
