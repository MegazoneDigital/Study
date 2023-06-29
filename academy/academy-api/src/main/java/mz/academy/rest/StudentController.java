package mz.academy.rest;


import java.util.List;
import lombok.RequiredArgsConstructor;
import mz.academy.domain.dto.StudentDto;
import mz.academy.domain.entity.Student;
import mz.academy.service.StudentFacade;
import mz.academy.service.StudentService;
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

@RequestMapping("/v1/students")
@RequiredArgsConstructor
@RestController
public class StudentController implements StudentFacade {

	private final StudentService studentService;

	@PostMapping
	@Override
	public ApiResponse<String> registerStudent(StudentDto studentDto) {
		return ApiResponseGenerator.success(studentService.registerStudent(studentDto));
	}

	@PutMapping
	@Override
	public ApiResponse<Void> modifyStudent(String id, NameValueList nameValues) {
		studentService.modifyStudent(id, nameValues);
		return ApiResponseGenerator.success();
	}

	@DeleteMapping
	@Override
	public ApiResponse<Void> removeStudent(String id) {
		studentService.removeStudent(id);
		return ApiResponseGenerator.success();
	}

	@GetMapping("{id}")
	@Override
	public ApiResponse<Student> findStudent(@PathVariable String id) {
		return ApiResponseGenerator.success(studentService.findStudent(id));
	}

	@GetMapping
	@Override
	public ApiResponse<List<Student>> findAllStudent() {
		return ApiResponseGenerator.success(studentService.findAllStudent());
	}
}
