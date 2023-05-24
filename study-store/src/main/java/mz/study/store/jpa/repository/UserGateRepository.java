package mz.study.store.jpa.repository;

import mz.study.store.jpa.entity.UserGateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGateRepository extends JpaRepository<UserGateEntity, String> {

}
