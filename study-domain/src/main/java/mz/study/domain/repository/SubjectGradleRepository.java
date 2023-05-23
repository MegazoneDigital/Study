package mz.study.domain.repository;

import mz.study.domain.entity.SubjectEntity;
import mz.study.domain.entity.SubjectGradleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectGradleRepository extends JpaRepository<SubjectGradleEntity, Long> {

}
