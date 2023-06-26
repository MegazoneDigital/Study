package mz.course.service;

import java.util.List;
import mz.common.api.ApiResponse;
import mz.common.domain.NameValueList;
import mz.course.domain.dto.CourseItemTeacherDto;
import mz.course.domain.entity.CourseItemTeacher;

public interface CourseItemTeacherFacade {

	ApiResponse<String> registerCourseItemTeacher(CourseItemTeacherDto courseItemTeacherDto);

	ApiResponse<Void> modifyCourseItemTeacher(String id, NameValueList nameValues);

	ApiResponse<Void> removeCourseItemTeacher(String id);

	ApiResponse<CourseItemTeacher> findCourseItemTeacher(String id);

	ApiResponse<List<CourseItemTeacher>> findAllCourseItemTeacher();
}
