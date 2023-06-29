package mz.course.service;

import java.util.List;
import mz.common.api.ApiResponse;
import mz.common.domain.NameValueList;
import mz.course.domain.dto.CourseDto;
import mz.course.domain.entity.Course;

public interface CourseFacade {

	ApiResponse<String> registerCourse(CourseDto courseDto);

	ApiResponse<Void> modifyCourse(String id, NameValueList nameValues);

	ApiResponse<Void> removeCourse(String id);

	ApiResponse<Course> findCourse(String id);

	ApiResponse<List<Course>> findAllCourse();
}
