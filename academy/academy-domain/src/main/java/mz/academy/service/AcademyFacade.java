package mz.academy.service;

import mz.academy.domain.dto.AcademyDto;
import mz.academy.domain.entity.Academy;
import mz.common.api.ApiResponse;
import mz.common.domain.NameValueList;

import java.util.List;

public interface AcademyFacade {

    ApiResponse<String> registerAcademy(AcademyDto academyDto);
    ApiResponse<Void> modifyAcademy(String id, NameValueList nameValues);
    ApiResponse<Void> removeAcademy(String id);
    ApiResponse<Academy> findAcademy(String id);
    ApiResponse<List<Academy>> findAllAcademy();
}
