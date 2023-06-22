package mz.usergate.service;

import mz.common.api.ApiResponse;
import mz.common.security.LoginSessionInfo;
import mz.usergate.domain.dto.LoginDto;

public interface AccountFacade {
    //
    ApiResponse<Boolean> login(LoginDto loginDto);  // 로그인
    ApiResponse<Void> logout(); // 로그아웃
    ApiResponse<LoginSessionInfo> getSessionInfo();  // 세션 객체 정보 조회
}
