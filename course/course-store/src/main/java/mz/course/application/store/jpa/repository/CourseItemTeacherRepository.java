package mz.course.application.store.jpa.repository;

import mz.course.application.store.jpa.entity.CourseItemTeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseItemTeacherRepository extends JpaRepository<CourseItemTeacherEntity, String> {

}
