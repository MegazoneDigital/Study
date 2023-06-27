package mz.course.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.common.domain.NameValueList;
import mz.course.application.store.BaseStore;
import mz.course.domain.dto.CourseItemTeacherDto;
import mz.course.domain.entity.CourseItemTeacher;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseItemTeacherService {

	private final BaseStore<CourseItemTeacher> courseItemTeacherStore;

	public String registerCourseItemTeacher(CourseItemTeacherDto courseItemTeacherDto) {
		return courseItemTeacherStore.create(courseItemTeacherDto.toDomain());
	}

	public void modifyCourseItemTeacher(String id, NameValueList nameValues) {
		CourseItemTeacher courseItemTeacher = courseItemTeacherStore.findById(id);
		courseItemTeacher.modifyValues(nameValues);
		courseItemTeacherStore.update(courseItemTeacher);
	}

	public void removeCourseItemTeacher(String id) {
		courseItemTeacherStore.delete(id);
	}

	public CourseItemTeacher findCourseItemTeacher(String id) {
		return courseItemTeacherStore.findById(id);
	}

	public List<CourseItemTeacher> findAllCourseItemTeacher() {
		return courseItemTeacherStore.findAll();
	}
}
