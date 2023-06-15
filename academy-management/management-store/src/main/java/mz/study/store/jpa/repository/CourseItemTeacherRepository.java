package mz.study.store.jpa.repository;

import mz.study.store.jpa.entity.CourseItemTeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseItemTeacherRepository extends JpaRepository<CourseItemTeacherEntity, String> {

}
