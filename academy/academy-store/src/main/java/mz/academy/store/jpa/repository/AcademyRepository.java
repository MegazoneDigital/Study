package mz.academy.store.jpa.repository;

import mz.academy.store.jpa.entity.AcademyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademyRepository extends JpaRepository<AcademyEntity, String> {

}
