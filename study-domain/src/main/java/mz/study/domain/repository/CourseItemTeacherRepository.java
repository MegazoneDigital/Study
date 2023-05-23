package mz.study.domain.repository;

import mz.study.domain.entity.CourseItemEntity;
import mz.study.domain.entity.CourseItemTeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseItemTeacherRepository extends JpaRepository<CourseItemTeacherEntity, Long> {

}
