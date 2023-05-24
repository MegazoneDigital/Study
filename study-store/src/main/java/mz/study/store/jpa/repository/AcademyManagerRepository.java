package mz.study.store.jpa.repository;

import mz.study.store.jpa.entity.AcademyManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademyManagerRepository extends JpaRepository<AcademyManagerEntity, String> {

}
