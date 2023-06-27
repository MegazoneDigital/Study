package mz.academy.rest;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mz.common.api.ApiResponse;
import mz.common.api.ApiResponseGenerator;
import mz.common.domain.NameValueList;
import mz.course.domain.dto.CoursePlanningDto;
import mz.course.domain.entity.CoursePlanning;
import mz.course.service.CoursePlanningFacade;
import mz.course.service.CoursePlanningService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/courseProjects")
@RequiredArgsConstructor
@RestController
public class CoursePlanningController implements CoursePlanningFacade {

	private final CoursePlanningService coursePlanningService;

	@PostMapping
	@Override
	public ApiResponse<String> registerCoursePlanning(CoursePlanningDto coursePlanningDto) {
		return ApiResponseGenerator.success(
				coursePlanningService.registerCoursePlanning(coursePlanningDto));
	}

	@PutMapping
	@Override
	public ApiResponse<Void> modifyCoursePlanning(String id, NameValueList nameValues) {
		coursePlanningService.modifyCoursePlanning(id, nameValues);
		return ApiResponseGenerator.success();
	}

	@DeleteMapping
	@Override
	public ApiResponse<Void> removeCoursePlanning(String id) {
		coursePlanningService.removeCoursePlanning(id);
		return ApiResponseGenerator.success();
	}

	@GetMapping("{id}")
	@Override
	public ApiResponse<CoursePlanning> findCoursePlanning(@PathVariable String id) {
		return ApiResponseGenerator.success(coursePlanningService.findCoursePlanning(id));
	}

	@GetMapping
	@Override
	public ApiResponse<List<CoursePlanning>> findAllCoursePlanning() {
		return ApiResponseGenerator.success(coursePlanningService.findAllCoursePlanning());
	}
}
