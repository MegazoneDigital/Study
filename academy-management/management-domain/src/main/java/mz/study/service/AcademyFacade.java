package mz.study.service;

import mz.common.api.ApiResponse;
import mz.common.domain.NameValueList;
import mz.study.domain.dto.AcademyDto;
import mz.study.domain.entity.Academy;

import java.util.List;

public interface AcademyFacade {

    ApiResponse<String> registerAcademy(AcademyDto academyDto);
    ApiResponse<Void> modifyAcademy(String id, NameValueList nameValues);
    ApiResponse<Void> removeAcademy(String id);
    ApiResponse<Academy> findAcademy(String id);
    ApiResponse<List<Academy>> findAllAcademy();
}
