package mz.academy.store.jpa.repository;

import mz.academy.store.jpa.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, String> {

}
