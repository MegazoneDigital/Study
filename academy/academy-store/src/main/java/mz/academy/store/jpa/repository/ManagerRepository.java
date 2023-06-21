package mz.academy.store.jpa.repository;

import mz.academy.store.jpa.entity.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<ManagerEntity, String> {

}
