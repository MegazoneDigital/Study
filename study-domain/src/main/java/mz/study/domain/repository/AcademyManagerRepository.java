package mz.study.domain.repository;

import mz.study.domain.entity.AcademyManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademyManagerRepository extends JpaRepository<AcademyManagerEntity, Long> {

}
