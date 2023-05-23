package mz.study.domain.repository;

import mz.study.domain.entity.SubjectGradleEntity;
import mz.study.domain.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {

}
