package mz.course.application.store.jpa;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.common.exception.EntityNotFoundException;
import mz.course.application.store.BaseStore;
import mz.course.application.store.jpa.entity.CoursePlanningEntity;
import mz.course.application.store.jpa.repository.CoursePlanningRepository;
import mz.course.domain.entity.CoursePlanning;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CoursePlanningJpaStore implements BaseStore<CoursePlanning> {

	private final CoursePlanningRepository coursePlanningRepository;

	@Override
	public String create(CoursePlanning coursePlanning) {

		CoursePlanningEntity coursePlanningEntity = new CoursePlanningEntity(coursePlanning);
		coursePlanningRepository.save(coursePlanningEntity);
		return coursePlanning.getId();
	}

	@Override
	public void update(CoursePlanning coursePlanning) {

		Optional<CoursePlanningEntity> optCoursePlanningEntity = coursePlanningRepository.findById(
				coursePlanning.getId());
		if (optCoursePlanningEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}
		CoursePlanningEntity savingEntity = optCoursePlanningEntity.get();
		BeanUtils.copyProperties(coursePlanning, this);
		coursePlanningRepository.save(savingEntity);
	}

	@Override
	public void delete(String id) {

		coursePlanningRepository.deleteById(id);
	}

	@Override
	public CoursePlanning findById(String id) {

		Optional<CoursePlanningEntity> optCoursePlanningEntity = coursePlanningRepository.findById(
				id);
		if (optCoursePlanningEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}
		return optCoursePlanningEntity.get().toDomain();
	}

	@Override
	public List<CoursePlanning> findAll() {
		return CoursePlanningEntity.toDomains(coursePlanningRepository.findAll());
	}
}
