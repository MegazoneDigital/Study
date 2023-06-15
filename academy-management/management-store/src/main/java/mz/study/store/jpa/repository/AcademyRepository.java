package mz.study.store.jpa.repository;

import mz.study.store.jpa.entity.AcademyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademyRepository extends JpaRepository<AcademyEntity, String> {

}
