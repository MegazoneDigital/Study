package mz.usergate.store.jpa.repository;

import mz.usergate.store.jpa.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, String> {

    List<AccountEntity> findByLoginId(String loginId);
}
