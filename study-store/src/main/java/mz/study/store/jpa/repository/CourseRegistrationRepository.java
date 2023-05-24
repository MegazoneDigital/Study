package mz.study.store.jpa.repository;

import mz.study.store.jpa.entity.CourseRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRegistrationRepository extends JpaRepository<CourseRegistrationEntity, String> {

}
