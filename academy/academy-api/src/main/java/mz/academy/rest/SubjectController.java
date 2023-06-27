package mz.academy.rest;


import java.util.List;
import lombok.RequiredArgsConstructor;
import mz.academy.domain.dto.SubjectDto;
import mz.academy.domain.entity.Subject;
import mz.academy.service.SubjectFacade;
import mz.academy.service.SubjectService;
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

@RequestMapping("/v1/subjects")
@RequiredArgsConstructor
@RestController
public class SubjectController implements SubjectFacade {

	private final SubjectService subjectService;

	@PostMapping
	@Override
	public ApiResponse<String> registerSubject(SubjectDto subjectDto) {
		return ApiResponseGenerator.success(
				subjectService.registerSubject(subjectDto));
	}

	@PutMapping
	@Override
	public ApiResponse<Void> modifySubject(String id, NameValueList nameValues) {
		subjectService.modifySubject(id, nameValues);
		return ApiResponseGenerator.success();
	}

	@DeleteMapping
	@Override
	public ApiResponse<Void> removeSubject(String id) {
		subjectService.removeSubject(id);
		return ApiResponseGenerator.success();
	}

	@GetMapping("{id}")
	@Override
	public ApiResponse<Subject> findSubject(@PathVariable String id) {
		return ApiResponseGenerator.success(subjectService.findSubject(id));
	}

	@GetMapping
	@Override
	public ApiResponse<List<Subject>> findAllSubject() {
		return ApiResponseGenerator.success(subjectService.findAllSubject());
	}
}
