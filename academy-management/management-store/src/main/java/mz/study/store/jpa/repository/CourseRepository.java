package mz.study.store.jpa.repository;

import mz.study.store.jpa.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, String> {

}
