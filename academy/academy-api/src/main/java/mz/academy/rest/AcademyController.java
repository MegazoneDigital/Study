package mz.academy.rest;

import lombok.RequiredArgsConstructor;
import mz.academy.event.EventProducer;
import mz.common.api.ApiResponse;
import mz.common.api.ApiResponseGenerator;
import mz.common.domain.NameValueList;
import mz.academy.domain.dto.AcademyDto;
import mz.academy.domain.entity.Academy;
import mz.academy.service.AcademyFacade;
import mz.academy.service.AcademyService;
import mz.common.domain.event.AccountRegisteredEvent;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/v1/academies")
@RequiredArgsConstructor
@RestController
public class AcademyController implements AcademyFacade {

	private final AcademyService academyService;
	private final EventProducer eventProducer;

	@Override
	@PostMapping
	public ApiResponse<String> registerAcademy(AcademyDto academyDto) {

		AccountRegisteredEvent event = new AccountRegisteredEvent(
				UUID.randomUUID().toString(),
				academyDto.getName(),
				academyDto.getPhone(),
				academyDto.getEmail()
		);
		eventProducer.produceAccountRegisteredEvent(event);

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
