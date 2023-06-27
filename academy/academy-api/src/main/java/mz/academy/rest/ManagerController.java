package mz.academy.rest;


import java.util.List;
import lombok.RequiredArgsConstructor;
import mz.academy.domain.dto.ManagerDto;
import mz.academy.domain.entity.Manager;
import mz.academy.service.ManagerFacade;
import mz.academy.service.ManagerService;
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

@RequestMapping("/v1/manages")
@RequiredArgsConstructor
@RestController
public class ManagerController implements ManagerFacade {

	private final ManagerService managerService;

	@PostMapping
	@Override
	public ApiResponse<String> registerManager(ManagerDto managerDto) {
		return ApiResponseGenerator.success(managerService.registerManager(managerDto));
	}

	@PutMapping
	@Override
	public ApiResponse<Void> modifyManager(String id, NameValueList nameValues) {
		managerService.modifyManager(id, nameValues);
		return ApiResponseGenerator.success();
	}

	@DeleteMapping
	@Override
	public ApiResponse<Void> removeManager(String id) {
		managerService.removeManager(id);
		return ApiResponseGenerator.success();
	}

	@GetMapping("{id}")
	@Override
	public ApiResponse<Manager> findManager(@PathVariable String id) {
		return ApiResponseGenerator.success(managerService.findManager(id));
	}

	@GetMapping
	@Override
	public ApiResponse<List<Manager>> findAllManager() {
		return ApiResponseGenerator.success(managerService.findAllManager());
	}
}
