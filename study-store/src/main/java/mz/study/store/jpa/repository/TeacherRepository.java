package mz.study.store.jpa.repository;

import mz.study.store.jpa.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, String> {

}
