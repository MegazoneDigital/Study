package mz.course.rest;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mz.common.api.ApiResponse;
import mz.common.api.ApiResponseGenerator;
import mz.common.domain.NameValueList;
import mz.course.domain.dto.CourseItemDto;
import mz.course.domain.entity.CourseItem;
import mz.course.service.CourseItemFacade;
import mz.course.service.CourseItemService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/courseItems")
@RequiredArgsConstructor
@RestController
public class CourseItemController implements CourseItemFacade {

	private final CourseItemService courseItemService;

	@PostMapping
	@Override
	public ApiResponse<String> registerCourseItem(CourseItemDto courseItemDto) {
		return ApiResponseGenerator.success(courseItemService.registerCourseItem(courseItemDto));
	}

	@PutMapping
	@Override
	public ApiResponse<Void> modifyCourseItem(String id, NameValueList nameValues) {
		courseItemService.modifyCourseItem(id, nameValues);
		return ApiResponseGenerator.success();
	}

	@DeleteMapping
	@Override
	public ApiResponse<Void> removeCourseItem(String id) {
		courseItemService.removeCourseItem(id);
		return ApiResponseGenerator.success();
	}

	@GetMapping("{id}")
	@Override
	public ApiResponse<CourseItem> findCourseItem(@PathVariable String id) {
		return ApiResponseGenerator.success(courseItemService.findCourseItem(id));
	}

	@GetMapping
	@Override
	public ApiResponse<List<CourseItem>> findAllCourseItem() {
		return ApiResponseGenerator.success(courseItemService.findAllCourseItem());
	}
}
