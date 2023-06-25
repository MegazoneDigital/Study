package mz.academy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.academy.domain.dto.CommonCodeDto;
import mz.academy.domain.entity.CommonCode;
import mz.academy.store.BaseStore;
import mz.common.domain.NameValueList;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommonCodeService {

    private final BaseStore<CommonCode> commonCodeStore;

    public String registerCommonCode(CommonCodeDto commonCodeDto) {

        return commonCodeStore.create(commonCodeDto.toDomain());
    }

    public void modifyCommonCode(String id, NameValueList nameValues) {
        CommonCode commonCode = commonCodeStore.findById(id);
        commonCode.modifyValues(nameValues);
        commonCodeStore.update(commonCode);
    }

    public void removeCommonCode(String id) {

        commonCodeStore.delete(id);
    }

    public CommonCode findAcademyManager(String id) {

        return commonCodeStore.findById(id);
    }

    public List<CommonCode> findAllAcademyManager() {

        return commonCodeStore.findAll();
    }
}
