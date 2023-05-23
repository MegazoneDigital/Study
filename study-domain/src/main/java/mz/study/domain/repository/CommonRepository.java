package mz.study.domain.repository;

import mz.study.domain.entity.CommonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonRepository extends JpaRepository<CommonEntity, Long> {

}
