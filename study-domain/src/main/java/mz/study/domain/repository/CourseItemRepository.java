package mz.study.domain.repository;

import mz.study.domain.entity.CourseEntity;
import mz.study.domain.entity.CourseItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseItemRepository extends JpaRepository<CourseItemEntity, Long> {

}
