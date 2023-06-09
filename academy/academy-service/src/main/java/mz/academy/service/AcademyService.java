package mz.academy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.academy.domain.dto.AcademyDto;
import mz.academy.domain.entity.Academy;
import mz.academy.store.BaseStore;
import mz.common.domain.NameValueList;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AcademyService{

    private final BaseStore<Academy> academyStore;

    public String registerAcademy(AcademyDto academyDto) {

        return academyStore.create(academyDto.toDomain());
    }

    public void modifyAcademy(String id, NameValueList nameValues) {
        Academy academy = academyStore.findById(id);
        academy.modifyValues(nameValues);
        academyStore.update(academy);
    }

    public void removeAcademy(String id) {

        academyStore.delete(id);
    }

    public Academy findAcademy(String id) {

        return academyStore.findById(id);
    }

    public List<Academy> findAllAcademy() {

        return academyStore.findAll();
    }
}
