package mz.academy.rest;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mz.academy.domain.dto.CommonCodeDto;
import mz.academy.domain.entity.CommonCode;
import mz.academy.service.CommonCodeFacade;
import mz.academy.service.CommonCodeService;
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

@RequestMapping("/v1/commonCode")
@RequiredArgsConstructor
@RestController
public class CommonCodeController implements CommonCodeFacade {

	private final CommonCodeService commonCodeService;

	@PostMapping
	@Override
	public ApiResponse<String> registerCommonCode(CommonCodeDto commonCodeDto) {
		return ApiResponseGenerator.success(commonCodeService.registerCommonCode(commonCodeDto));
	}

	@PutMapping
	@Override
	public ApiResponse<Void> modifyCommonCode(String id, NameValueList nameValues) {
		commonCodeService.modifyCommonCode(id, nameValues);
		return ApiResponseGenerator.success();
	}

	@DeleteMapping
	@Override
	public ApiResponse<Void> removeCommonCode(String id) {
		commonCodeService.removeCommonCode(id);
		return ApiResponseGenerator.success();
	}

	@GetMapping("{id}")
	@Override
	public ApiResponse<CommonCode> findCommonCode(@PathVariable String id) {
		return ApiResponseGenerator.success(commonCodeService.findAcademyManager(id));
	}

	@GetMapping
	@Override
	public ApiResponse<List<CommonCode>> findAllCommonCode() {
		return ApiResponseGenerator.success(commonCodeService.findAllAcademyManager());
	}
}
