package mz.study.domain.repository;

import mz.study.domain.entity.AcademyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademyRepository extends JpaRepository<AcademyEntity, Long> {

}
