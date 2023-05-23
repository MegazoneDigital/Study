package mz.study.domain.repository;

import mz.study.domain.entity.StudentEntity;
import mz.study.domain.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {

}
