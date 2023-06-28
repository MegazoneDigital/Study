package mz.course.rest;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mz.common.api.ApiResponse;
import mz.common.api.ApiResponseGenerator;
import mz.common.domain.NameValueList;
import mz.course.domain.dto.CourseDto;
import mz.course.domain.entity.Course;
import mz.course.service.CourseFacade;
import mz.course.service.CourseService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/courses")
@RequiredArgsConstructor
@RestController
public class CourseController implements CourseFacade {

	private final CourseService courseService;

	@PostMapping
	@Override
	public ApiResponse<String> registerCourse(CourseDto courseDto) {
		return ApiResponseGenerator.success(courseService.registerCourse(courseDto));
	}

	@PutMapping
	@Override
	public ApiResponse<Void> modifyCourse(String id, NameValueList nameValues) {
		courseService.modifyCourse(id, nameValues);
		return ApiResponseGenerator.success();
	}

	@DeleteMapping
	@Override
	public ApiResponse<Void> removeCourse(String id) {
		courseService.removeCourse(id);
		return ApiResponseGenerator.success();
	}

	@GetMapping("{id}")
	@Override
	public ApiResponse<Course> findCourse(@PathVariable String id) {
		return ApiResponseGenerator.success(courseService.findCourse(id));
	}

	@GetMapping
	@Override
	public ApiResponse<List<Course>> findAllCourse() {
		return ApiResponseGenerator.success(courseService.findAllCourse());
	}
}
