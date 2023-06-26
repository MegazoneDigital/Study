package mz.academy.rest;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mz.academy.domain.dto.TeacherDto;
import mz.academy.domain.entity.Teacher;
import mz.academy.service.TeacherFacade;
import mz.academy.service.TeacherService;
import mz.common.api.ApiResponse;
import mz.common.api.ApiResponseGenerator;
import mz.common.domain.NameValueList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/teachers")
@RequiredArgsConstructor
@RestController
public class TeacherController implements TeacherFacade {

	private final TeacherService teacherService;

	@PostMapping
	@Override
	public ApiResponse<String> registerTeacher(TeacherDto teacherDto) {
		return ApiResponseGenerator.success(teacherService.registerTeacher(teacherDto));
	}

	@PutMapping
	@Override
	public ApiResponse<Void> modifyTeacher(String id, NameValueList nameValues) {
		teacherService.modifyTeacher(id, nameValues);
		return ApiResponseGenerator.success();
	}

	@DeleteMapping
	@Override
	public ApiResponse<Void> removeTeacher(String id) {
		teacherService.removeTeacher(id);
		return ApiResponseGenerator.success();
	}

	@GetMapping("{id}")
	@Override
	public ApiResponse<Teacher> findTeacher(@PathVariable String id) {
		return ApiResponseGenerator.success(teacherService.findTeacher(id));
	}

	@GetMapping
	@Override
	public ApiResponse<List<Teacher>> findAllTeacher() {
		return ApiResponseGenerator.success(teacherService.findAllTeacher());
	}
}
