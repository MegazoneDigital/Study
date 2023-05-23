package mz.study.domain.repository;

import mz.study.domain.entity.CourseItemTeacherEntity;
import mz.study.domain.entity.CoursePlanningEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursePlanningRepository extends JpaRepository<CoursePlanningEntity, Long> {

}
