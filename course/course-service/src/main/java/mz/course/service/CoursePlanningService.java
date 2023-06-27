package mz.course.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.common.domain.NameValueList;
import mz.course.application.store.BaseStore;
import mz.course.domain.dto.CoursePlanningDto;
import mz.course.domain.entity.CoursePlanning;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CoursePlanningService {

	private final BaseStore<CoursePlanning> coursePlanningStore;

	public String registerCoursePlanning(CoursePlanningDto coursePlanningDto) {
		return coursePlanningStore.create(coursePlanningDto.toDomain());
	}

	public void modifyCoursePlanning(String id, NameValueList nameValues) {
		CoursePlanning coursePlanning = coursePlanningStore.findById(id);
		coursePlanning.modifyValues(nameValues);
		coursePlanningStore.update(coursePlanning);
	}

	public void removeCoursePlanning(String id) {
		coursePlanningStore.delete(id);
	}

	public CoursePlanning findCoursePlanning(String id) {
		return coursePlanningStore.findById(id);
	}

	public List<CoursePlanning> findAllCoursePlanning() {
		return coursePlanningStore.findAll();
	}
}
