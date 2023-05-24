package mz.study.store.jpa.repository;

import mz.study.store.jpa.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectEntity, String> {

}
