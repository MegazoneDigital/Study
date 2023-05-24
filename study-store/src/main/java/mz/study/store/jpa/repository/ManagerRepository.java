package mz.study.store.jpa.repository;

import mz.study.store.jpa.entity.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<ManagerEntity, String> {

}
