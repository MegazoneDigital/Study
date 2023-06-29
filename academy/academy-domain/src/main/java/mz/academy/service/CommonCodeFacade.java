package mz.academy.service;

import mz.academy.domain.dto.CommonCodeDto;
import mz.academy.domain.entity.CommonCode;
import mz.common.api.ApiResponse;
import mz.common.domain.NameValueList;

import java.util.List;

public interface CommonCodeFacade {

    ApiResponse<String> registerCommonCode(CommonCodeDto commonCodeDto);

    ApiResponse<Void> modifyCommonCode(String id, NameValueList nameValues);

    ApiResponse<Void> removeCommonCode(String id);

    ApiResponse<CommonCode> findCommonCode(String id);

    ApiResponse<List<CommonCode>> findAllCommonCode();
}
