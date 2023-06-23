package mz.academy.event.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.academy.event.EventProducer;
import mz.common.domain.event.AccountRegisteredEvent;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!local")
@Slf4j
@RequiredArgsConstructor
@Component
public class EventBinder implements EventProducer {

    private final StreamBridge streamBridge;

    @Override
    public void produceAccountRegisteredEvent(AccountRegisteredEvent accountRegisteredEvent) {
        //
        streamBridge.send("accountRegistered", accountRegisteredEvent);
        log.debug("produceAccountRegisteredEvent \n{}", accountRegisteredEvent.toPrettyJson());
    }
}
