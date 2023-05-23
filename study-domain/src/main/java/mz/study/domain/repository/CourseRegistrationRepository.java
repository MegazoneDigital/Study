package mz.study.domain.repository;

import mz.study.domain.entity.CoursePlanningEntity;
import mz.study.domain.entity.CourseRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRegistrationRepository extends JpaRepository<CourseRegistrationEntity, Long> {

}
