package mz.usergate.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.event.DomainEvent;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountRegisteredEvent implements DomainEvent {

    private String id;
    private String loginId;
    private String password;
    private String email;
}
