package mz.academy.event.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.academy.event.EventProducer;
import mz.common.domain.event.AccountRegisteredEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("local")
@Slf4j
@RequiredArgsConstructor
@Component
public class EventLocalBinder implements EventProducer {

    @Override
    public void produceAccountRegisteredEvent(AccountRegisteredEvent accountRegisteredEvent) {
        //
        log.debug("produceAccountRegisteredEvent \n{}", accountRegisteredEvent.toPrettyJson());
    }
}
