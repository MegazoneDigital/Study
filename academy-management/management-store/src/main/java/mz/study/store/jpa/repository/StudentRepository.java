package mz.study.store.jpa.repository;

import mz.study.store.jpa.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, String> {

}
