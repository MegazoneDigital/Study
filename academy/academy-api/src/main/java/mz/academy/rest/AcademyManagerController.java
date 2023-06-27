package mz.academy.rest;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mz.academy.domain.dto.AcademyManagerDto;
import mz.academy.domain.entity.AcademyManager;
import mz.academy.service.AcademyManagerFacade;
import mz.academy.service.AcademyManagerService;
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

@RequestMapping("/v1/academyManagers")
@RequiredArgsConstructor
@RestController
public class AcademyManagerController implements AcademyManagerFacade {

	private final AcademyManagerService academyManagerService;

	@PostMapping
	@Override
	public ApiResponse<String> registerAcademyManager(AcademyManagerDto academyManagerDto) {
		return ApiResponseGenerator.success(
				academyManagerService.registerAcademyManager(academyManagerDto));
	}

	@PutMapping
	@Override
	public ApiResponse<Void> modifyAcademyManager(String id, NameValueList nameValues) {
		academyManagerService.modifyAcademyManager(id, nameValues);
		return ApiResponseGenerator.success();
	}

	@DeleteMapping
	@Override
	public ApiResponse<Void> removeAcademyManager(String id) {
		academyManagerService.removeAcademyManager(id);
		return ApiResponseGenerator.success();
	}

	@GetMapping("{id}")
	@Override
	public ApiResponse<AcademyManager> findAcademyManager(@PathVariable String id) {
		return ApiResponseGenerator.success(
				academyManagerService.findAcademyManager(id));
	}

	@GetMapping
	@Override
	public ApiResponse<List<AcademyManager>> findAllAcademyManager() {
		return ApiResponseGenerator.success(
				academyManagerService.findAllAcademyManager());
	}
}
