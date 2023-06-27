package mz.course.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.common.domain.NameValueList;
import mz.course.application.store.BaseStore;
import mz.course.domain.dto.CourseItemDto;
import mz.course.domain.entity.CourseItem;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseItemService {

	private final BaseStore<CourseItem> courseItemStore;

	public String registerCourseItem(CourseItemDto courseItemDto) {
		return courseItemStore.create(courseItemDto.toDomain());
	}

	public void modifyCourseItem(String id, NameValueList nameValues) {
		CourseItem courseItem = courseItemStore.findById(id);
		courseItem.modifyValues(nameValues);
		courseItemStore.update(courseItem);
	}

	public void removeCourseItem(String id) {
		courseItemStore.delete(id);
	}

	public CourseItem findCourseItem(String id) {
		return courseItemStore.findById(id);
	}

	public List<CourseItem> findAllCourseItem() {
		return courseItemStore.findAll();
	}
}
