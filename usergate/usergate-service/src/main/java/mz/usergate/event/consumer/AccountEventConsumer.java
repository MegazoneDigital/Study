package mz.usergate.event.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.common.domain.event.AccountRegisteredEvent;
import mz.common.util.json.JsonUtils;
import mz.usergate.domain.dto.AccountDto;
import mz.usergate.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class AccountEventConsumer {

    private final AccountService accountService;

    @Bean
    public Consumer accountRegistered() {

        return (e) -> {
            try {
                AccountRegisteredEvent event
                        = JsonUtils.fromJson(e.toString(), AccountRegisteredEvent.class);
                log.debug("Started AccountRegisteredEvent \n{}", event.toPrettyJson());
                accountService.saveAccount(
                        AccountDto.builder()
                                .id(event.getId())
                                .loginId(event.getLoginId())
                                .password(event.getPassword())
                                .email(event.getEmail())
                                .build()
                );

            } catch (RuntimeException ex) {
                log.error("AccountRegisteredEvent error.", ex);
            }
        };
    }
}
