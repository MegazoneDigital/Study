package mz.usergate.store;

import mz.usergate.domain.entity.Account;

import java.util.List;

public interface AccountStore {
    //
    String create(Account account);
    void update(Account account);
    void delete(String id);
    Account findAccount(String id);

    List<Account> findAll();
}
