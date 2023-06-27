package mz.course.application.store.jpa;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.common.exception.EntityNotFoundException;
import mz.course.application.store.BaseStore;
import mz.course.application.store.jpa.entity.CourseItemTeacherEntity;
import mz.course.application.store.jpa.repository.CourseItemTeacherRepository;
import mz.course.domain.entity.CourseItemTeacher;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CourseItemTeacherJpaStore implements BaseStore<CourseItemTeacher> {

	private final CourseItemTeacherRepository courseItemTeacherRepository;

	@Override
	public String create(CourseItemTeacher courseItemTeacher) {

		CourseItemTeacherEntity courseItemTeacherEntity = new CourseItemTeacherEntity(
				courseItemTeacher);
		courseItemTeacherRepository.save(courseItemTeacherEntity);
		return courseItemTeacher.getId();
	}

	@Override
	public void update(CourseItemTeacher courseItemTeacher) {

		Optional<CourseItemTeacherEntity> optCourseItemTeacherEntity = courseItemTeacherRepository.findById(
				courseItemTeacher.getId());
		if (optCourseItemTeacherEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}
		CourseItemTeacherEntity savingEntity = optCourseItemTeacherEntity.get();
		BeanUtils.copyProperties(courseItemTeacher, this);
		courseItemTeacherRepository.save(savingEntity);
	}

	@Override
	public void delete(String id) {
		courseItemTeacherRepository.deleteById(id);
	}

	@Override
	public CourseItemTeacher findById(String id) {
		Optional<CourseItemTeacherEntity> optCourseItemTeacherEntity = courseItemTeacherRepository.findById(
				id);
		if (optCourseItemTeacherEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}
		return optCourseItemTeacherEntity.get().toDomain();
	}

	@Override
	public List<CourseItemTeacher> findAll() {
		return CourseItemTeacherEntity.toDomains(courseItemTeacherRepository.findAll());
	}
}
