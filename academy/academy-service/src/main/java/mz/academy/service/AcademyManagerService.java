package mz.academy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.academy.domain.dto.AcademyManagerDto;
import mz.academy.domain.entity.AcademyManager;
import mz.academy.store.BaseStore;
import mz.common.domain.NameValueList;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AcademyManagerService {

    private final BaseStore<AcademyManager> academyManagerStore;

    public String registerAcademyManager(AcademyManagerDto academyManagerDto) {

        return academyManagerStore.create(academyManagerDto.toDomain());
    }

    public void modifyAcademyManager(String id, NameValueList nameValues) {
        AcademyManager academyManager = academyManagerStore.findById(id);
        academyManager.modifyValues(nameValues);
        academyManagerStore.update(academyManager);
    }

    public void removeAcademyManager(String id) {

        academyManagerStore.delete(id);
    }

    public AcademyManager findAcademyManager(String id) {

        return academyManagerStore.findById(id);
    }

    public List<AcademyManager> findAllAcademyManager() {

        return academyManagerStore.findAll();
    }
}
