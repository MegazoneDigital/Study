package mz.academy.service;

import mz.academy.domain.dto.AcademyManagerDto;
import mz.academy.domain.entity.AcademyManager;
import mz.common.api.ApiResponse;
import mz.common.domain.NameValueList;

import java.util.List;

public interface AcademyManagerFacade {

    ApiResponse<String> registerAcademyManager(AcademyManagerDto academyManagerDto);

    ApiResponse<Void> modifyAcademyManager(String id, NameValueList nameValues);

    ApiResponse<Void> removeAcademyManager(String id);

    ApiResponse<AcademyManager> findAcademyManager(String id);

    ApiResponse<List<AcademyManager>> findAllAcademyManager();
}
