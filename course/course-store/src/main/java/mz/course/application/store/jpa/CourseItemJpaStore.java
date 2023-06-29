package mz.course.application.store.jpa;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.common.exception.EntityNotFoundException;
import mz.course.application.store.BaseStore;
import mz.course.application.store.jpa.entity.CourseItemEntity;
import mz.course.application.store.jpa.repository.CourseItemRepository;
import mz.course.domain.entity.CourseItem;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CourseItemJpaStore implements BaseStore<CourseItem> {

	private final CourseItemRepository courseItemRepository;

	@Override
	public String create(CourseItem courseItem) {

		CourseItemEntity courseItemEntity = new CourseItemEntity(courseItem);
		courseItemRepository.save(courseItemEntity);
		return courseItem.getId();
	}

	@Override
	public void update(CourseItem courseItem) {

		Optional<CourseItemEntity> optCourseItemEntity = courseItemRepository.findById(courseItem.getId());
		if(optCourseItemEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}
		CourseItemEntity savingEntity = optCourseItemEntity.get();
		BeanUtils.copyProperties(courseItem, this);
		courseItemRepository.save(savingEntity);
	}

	@Override
	public void delete(String id) {
		courseItemRepository.deleteById(id);
	}

	@Override
	public CourseItem findById(String id) {
		Optional<CourseItemEntity> optCourseItemEntity = courseItemRepository.findById(id);
		if(optCourseItemEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}
		return optCourseItemEntity.get().toDomain();
	}

	@Override
	public List<CourseItem> findAll() {
		return CourseItemEntity.toDomains(courseItemRepository.findAll());
	}
}
