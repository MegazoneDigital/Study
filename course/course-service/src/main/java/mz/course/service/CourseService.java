package mz.course.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.common.domain.NameValueList;
import mz.course.application.store.BaseStore;
import mz.course.domain.dto.CourseDto;
import mz.course.domain.entity.Course;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {

	private final BaseStore<Course> courseStore;

	public String registerCourse(CourseDto courseDto) {
		return courseStore.create(courseDto.toDomain());
	}

	public void modifyCourse(String id, NameValueList nameValues) {
		Course course = courseStore.findById(id);
		course.modifyValues(nameValues);
		courseStore.update(course);
	}

	public void removeCourse(String id) {
		courseStore.delete(id);
	}

	public Course findCourse(String id) {
		return courseStore.findById(id);
	}

	public List<Course> findAllCourse() {
		return courseStore.findAll();
	}
}
