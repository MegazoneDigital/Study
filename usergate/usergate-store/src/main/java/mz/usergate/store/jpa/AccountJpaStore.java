package mz.usergate.store.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.usergate.domain.entity.Account;
import mz.usergate.store.AccountStore;
import mz.usergate.store.jpa.entity.AccountEntity;
import mz.usergate.store.jpa.repository.AccountRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class AccountJpaStore implements AccountStore {

    private final AccountRepository accountRepository;

    @Override
    public String save(Account account) {

        AccountEntity savedEntity;
        Optional<AccountEntity> optAccountEntity = accountRepository.findById(account.getId());
        if(optAccountEntity.isEmpty()) {
            AccountEntity accountEntity = new AccountEntity(account);
            savedEntity = accountRepository.save(accountEntity);
        } else {
            savedEntity = optAccountEntity.get();
            savedEntity.setPassword(account.getPassword());
            savedEntity.setEmail(account.getEmail());
            accountRepository.save(savedEntity);
        }

        return savedEntity.getId();
    }

    @Override
    public void delete(String id) {

        accountRepository.deleteById(id);
    }

    @Override
    public Account findAccount(String id) {

        Optional<AccountEntity> optAccountEntity = accountRepository.findById(id);
        if(optAccountEntity.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return optAccountEntity.get().toDomain();
    }

    @Override
    public List<Account> findByLoginId(String loginId) {

        List<Account> accounts = new ArrayList<>();

        List<AccountEntity> accountEntities = accountRepository.findByLoginId(loginId);
        if( accountEntities != null || accountEntities.size() > 0 ) {
            accounts = AccountEntity.toDomains(accountEntities);
        }

        return accounts;
    }
}
