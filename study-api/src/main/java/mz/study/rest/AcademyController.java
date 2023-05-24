package mz.study.rest;

import lombok.RequiredArgsConstructor;
import mz.common.api.ApiResponse;
import mz.common.api.ApiResponseGenerator;
import mz.common.domain.NameValueList;
import mz.study.domain.dto.AcademyDto;
import mz.study.domain.entity.Academy;
import mz.study.service.AcademyFacade;
import mz.study.service.AcademyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/academies")
@RequiredArgsConstructor
@RestController
public class AcademyController implements AcademyFacade {

	private final AcademyService academyService;

	@Override
	@PostMapping
	public ApiResponse<String> registerAcademy(AcademyDto academyDto) {

		return ApiResponseGenerator.success(academyService.registerAcademy(academyDto));
	}

	@Override
	@PutMapping
	public ApiResponse<Void> modifyAcademy(String id, NameValueList nameValues) {

		academyService.modifyAcademy(id, nameValues);
		return ApiResponseGenerator.success();
	}

	@Override
	@DeleteMapping("/{id}")
	public ApiResponse<Void> removeAcademy(@PathVariable String id) {

		academyService.removeAcademy(id);
		return ApiResponseGenerator.success();
	}

	@Override
	@GetMapping("/{id}")
	public ApiResponse<Academy> findAcademy(@PathVariable String id) {

		return ApiResponseGenerator.success(academyService.findAcademy(id));
	}

	@Override
	@GetMapping
	public ApiResponse<List<Academy>> findAllAcademy() {

		return ApiResponseGenerator.success(academyService.findAllAcademy());
	}
}
