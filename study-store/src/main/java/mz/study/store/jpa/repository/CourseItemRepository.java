package mz.study.store.jpa.repository;

import mz.study.store.jpa.entity.CourseItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseItemRepository extends JpaRepository<CourseItemEntity, String> {

}
