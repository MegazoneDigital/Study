package mz.academy.store.jpa.repository;

import mz.academy.store.jpa.entity.SubjectGradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectGradeRepository extends JpaRepository<SubjectGradeEntity, String> {

}
