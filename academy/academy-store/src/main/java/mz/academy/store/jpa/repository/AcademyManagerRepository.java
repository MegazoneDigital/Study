package mz.academy.store.jpa.repository;

import mz.academy.store.jpa.entity.AcademyManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademyManagerRepository extends JpaRepository<AcademyManagerEntity, String> {

}
