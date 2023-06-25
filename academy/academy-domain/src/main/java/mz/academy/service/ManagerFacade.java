package mz.academy.service;

import mz.academy.domain.dto.ManagerDto;
import mz.academy.domain.entity.Manager;
import mz.common.api.ApiResponse;
import mz.common.domain.NameValueList;

import java.util.List;

public interface ManagerFacade {

    ApiResponse<String> registerManager(ManagerDto managerDto);

    ApiResponse<Void> modifyManager(String id, NameValueList nameValues);

    ApiResponse<Void> removeManager(String id);

    ApiResponse<Manager> findManager(String id);

    ApiResponse<List<Manager>> findAllManager();
}
