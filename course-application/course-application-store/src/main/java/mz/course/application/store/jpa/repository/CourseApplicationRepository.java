package mz.course.application.store.jpa.repository;

import mz.course.application.store.jpa.entity.CourseApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseApplicationRepository extends JpaRepository<CourseApplicationEntity, String> {

}
