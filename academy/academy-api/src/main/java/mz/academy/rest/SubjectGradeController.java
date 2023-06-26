package mz.academy.rest;


import java.util.List;
import lombok.RequiredArgsConstructor;
import mz.academy.domain.dto.SubjectGradeDto;
import mz.academy.domain.entity.SubjectGrade;
import mz.academy.service.SubjectGradeFacade;
import mz.academy.service.SubjectGradeService;
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

@RequestMapping("/v1/subjectGrades")
@RequiredArgsConstructor
@RestController
public class SubjectGradeController implements SubjectGradeFacade {

	private final SubjectGradeService subjectGradeService;

	@PostMapping
	@Override
	public ApiResponse<String> registerSubjectGrade(SubjectGradeDto subjectGradeDto) {
		return ApiResponseGenerator.success(
				subjectGradeService.registerSubjectGrade(subjectGradeDto));
	}

	@PutMapping
	@Override
	public ApiResponse<Void> modifySubjectGrade(String id, NameValueList nameValues) {
		subjectGradeService.modifySubjectGrade(id, nameValues);
		return ApiResponseGenerator.success();
	}

	@DeleteMapping
	@Override
	public ApiResponse<Void> removeSubjectGrade(String id) {
		subjectGradeService.removeSubjectGrade(id);
		return ApiResponseGenerator.success();
	}

	@GetMapping("{id}")
	@Override
	public ApiResponse<SubjectGrade> findSubjectGrade(@PathVariable String id) {
		return ApiResponseGenerator.success(subjectGradeService.findSubjectGrade(id));
	}

	@GetMapping
	@Override
	public ApiResponse<List<SubjectGrade>> findAllSubjectGrade() {
		return ApiResponseGenerator.success(subjectGradeService.findAllSubjectGrade());
	}
}
