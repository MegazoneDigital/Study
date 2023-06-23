package mz.academy.store.jpa;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.academy.domain.entity.Teacher;
import mz.academy.store.BaseStore;
import mz.academy.store.jpa.entity.TeacherEntity;
import mz.academy.store.jpa.repository.TeacherRepository;
import mz.common.exception.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class TeacherJpaStore implements BaseStore<Teacher> {

	private final TeacherRepository teacherRepository;

	@Override
	public String create(Teacher teacher) {

		TeacherEntity teacherEntity = new TeacherEntity(teacher);
		teacherRepository.save(teacherEntity);
		return teacher.getId();
	}

	@Override
	public void update(Teacher teacher) {

		Optional<TeacherEntity> optTeacherEntity = teacherRepository.findById(teacher.getId());
		if(optTeacherEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}
		TeacherEntity savingEntity = optTeacherEntity.get();
		BeanUtils.copyProperties(teacher, this);
		teacherRepository.save(savingEntity);
	}

	@Override
	public void delete(String id) {
		teacherRepository.deleteById(id);
	}

	@Override
	public Teacher findAcademy(String id) {
		Optional<TeacherEntity> optTeacherEntity = teacherRepository.findById(id);
		if(optTeacherEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}
		return optTeacherEntity.get().toDomain();
	}

	@Override
	public List<Teacher> findAll() {
		return TeacherEntity.toDomains(teacherRepository.findAll());
	}
}
