package mz.usergate.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.common.util.security.PasswordEncoder;
import mz.usergate.domain.dto.AccountDto;
import mz.usergate.domain.dto.LoginDto;
import mz.usergate.domain.entity.Account;
import mz.usergate.store.AccountStore;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountStore accountStore;

    public String registerAccount(AccountDto accountDto) {

        PasswordEncoder encoder = new PasswordEncoder();
        Account account = accountDto.toDomain();
        account.setEmail(
                encoder.encode(accountDto.getPassword())
        );
        return accountStore.create(account);
    }

    public void modifyAccount(AccountDto accountDto) {
        Account account = accountStore.findAccount(accountDto.getLoginId());
        account.setPassword(accountDto.getPassword());
        account.setEmail(accountDto.getEmail());
        accountStore.update(account);
    }

    public void removeAccount(String id) {

        accountStore.delete(id);
    }

    public Account findAccount(String id) {

        return accountStore.findAccount(id);
    }
}
