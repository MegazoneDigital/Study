package mz.course.rest;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mz.common.api.ApiResponse;
import mz.common.api.ApiResponseGenerator;
import mz.common.domain.NameValueList;
import mz.course.domain.dto.CourseItemTeacherDto;
import mz.course.domain.entity.CourseItemTeacher;
import mz.course.service.CourseItemTeacherFacade;
import mz.course.service.CourseItemTeacherService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/courseItemTeachers")
@RequiredArgsConstructor
@RestController
public class CourseItemTeacherController implements CourseItemTeacherFacade {

	private final CourseItemTeacherService courseItemTeacherService;

	@PostMapping
	@Override
	public ApiResponse<String> registerCourseItemTeacher(
			CourseItemTeacherDto courseItemTeacherDto) {
		return ApiResponseGenerator.success(
				courseItemTeacherService.registerCourseItemTeacher(courseItemTeacherDto));
	}

	@PutMapping
	@Override
	public ApiResponse<Void> modifyCourseItemTeacher(String id, NameValueList nameValues) {
		courseItemTeacherService.modifyCourseItemTeacher(id, nameValues);
		return ApiResponseGenerator.success();
	}

	@DeleteMapping
	@Override
	public ApiResponse<Void> removeCourseItemTeacher(String id) {
		courseItemTeacherService.removeCourseItemTeacher(id);
		return ApiResponseGenerator.success();
	}

	@GetMapping("{id}")
	@Override
	public ApiResponse<CourseItemTeacher> findCourseItemTeacher(@PathVariable String id) {
		return ApiResponseGenerator.success(courseItemTeacherService.findCourseItemTeacher(id));
	}

	@GetMapping
	@Override
	public ApiResponse<List<CourseItemTeacher>> findAllCourseItemTeacher() {
		return ApiResponseGenerator.success(courseItemTeacherService.findAllCourseItemTeacher());
	}
}
