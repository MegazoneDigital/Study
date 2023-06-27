package mz.academy.store.jpa;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.academy.domain.entity.Student;
import mz.academy.store.BaseStore;
import mz.academy.store.jpa.entity.StudentEntity;
import mz.academy.store.jpa.repository.StudentRepository;
import mz.common.exception.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class StudentJpaStore implements BaseStore<Student> {

	private final StudentRepository studentRepository;

	@Override
	public String create(Student student) {

		StudentEntity studentEntity = new StudentEntity(student);
		studentRepository.save(studentEntity);
		return student.getId();
	}

	@Override
	public void update(Student student) {

		Optional<StudentEntity> optStudentEntity = studentRepository.findById(student.getId());
		if(optStudentEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}
		StudentEntity savingEntity = optStudentEntity.get();
		BeanUtils.copyProperties(student, this);
		studentRepository.save(savingEntity);
	}

	@Override
	public void delete(String id) {

		studentRepository.deleteById(id);
	}

	@Override
	public Student findById(String id) {

		Optional<StudentEntity> optStudentEntity = studentRepository.findById(id);
		if(optStudentEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}
		return optStudentEntity.get().toDomain();
	}

	@Override
	public List<Student> findAll() {
		return StudentEntity.toDomains(studentRepository.findAll());
	}
}
