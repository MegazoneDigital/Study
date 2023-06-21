package mz.course.application.store.jpa.repository;

import mz.course.application.store.jpa.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, String> {

}
