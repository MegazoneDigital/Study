package mz.study.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.common.api.ApiResponse;
import mz.common.api.ApiResponseGenerator;
import mz.common.domain.NameValueList;
import mz.study.domain.dto.AcademyDto;
import mz.study.domain.entity.Academy;
import mz.study.store.AcademyStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AcademyService{

    private final AcademyStore academyStore;

    public String registerAcademy(AcademyDto academyDto) {

        return academyStore.create(academyDto.toDomain());
    }

    public void modifyAcademy(String id, NameValueList nameValues) {
        Academy academy = academyStore.findAcademy(id);
        academy.modifyValues(nameValues);
        academyStore.update(academy);
    }

    public void removeAcademy(String id) {

        academyStore.delete(id);
    }

    public Academy findAcademy(String id) {

        return academyStore.findAcademy(id);
    }

    public List<Academy> findAllAcademy() {

        return academyStore.findAll();
    }
}
