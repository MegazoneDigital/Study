package mz.usergate.store.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.usergate.domain.entity.Account;
import mz.usergate.store.AccountStore;
import mz.usergate.store.jpa.repository.AccountRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class AccountJpaStore implements AccountStore {

    private final AccountRepository accountRepository;

    @Override
    public String create(Account account) {
        return null;
    }

    @Override
    public void update(Account account) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Account findAccount(String id) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }
}
