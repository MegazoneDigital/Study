package mz.usergate.rest;

import lombok.RequiredArgsConstructor;
import mz.common.Constant;
import mz.common.api.ApiResponse;
import mz.common.api.ApiResponseGenerator;
import mz.common.security.LoginSessionInfo;
import mz.common.util.ServletUtils;
import mz.usergate.domain.dto.AccountDto;
import mz.usergate.domain.dto.LoginDto;
import mz.usergate.service.AccountService;
import mz.usergate.service.UserGateFacade;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/v1/usergate")
@RequiredArgsConstructor
@RestController
public class UserGateController implements UserGateFacade {

	private final AccountService accountService;

	@Override
	@PostMapping("/register")
	public ApiResponse<String> register(@RequestBody AccountDto accountDto) {

		return ApiResponseGenerator.success(accountService.saveAccount(accountDto));
	}

	@Override
	@PostMapping("/login")
	public ApiResponse<Boolean> login(@RequestBody LoginDto loginDto) {

		return ApiResponseGenerator.success(accountService.login(loginDto));
	}

	@Override
	@GetMapping("/logout")
	public ApiResponse<Void> logout() {

		HttpServletRequest request = ServletUtils.getRequest();
		request.getSession().removeAttribute(Constant.LOGIN_SESSION_INFO);
		return ApiResponseGenerator.success();
	}

	@Override
	@GetMapping("/session-info")
	public ApiResponse<LoginSessionInfo> getSessionInfo() {

		HttpServletRequest request = ServletUtils.getRequest();
		return ApiResponseGenerator.success(
				(LoginSessionInfo)request.getSession().getAttribute(Constant.LOGIN_SESSION_INFO));
	}
}
