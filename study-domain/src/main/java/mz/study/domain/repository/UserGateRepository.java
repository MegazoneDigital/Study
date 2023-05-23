package mz.study.domain.repository;

import mz.study.domain.entity.TeacherEntity;
import mz.study.domain.entity.UserGateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGateRepository extends JpaRepository<UserGateEntity, String> {

}
