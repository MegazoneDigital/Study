package mz.study.domain.repository;

import mz.study.domain.entity.CourseRegistrationEntity;
import mz.study.domain.entity.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<ManagerEntity, Long> {

}
