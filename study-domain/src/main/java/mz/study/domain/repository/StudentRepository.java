package mz.study.domain.repository;

import mz.study.domain.entity.ManagerEntity;
import mz.study.domain.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
