package mz.academy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.academy.domain.dto.ManagerDto;
import mz.academy.domain.entity.Manager;
import mz.academy.store.BaseStore;
import mz.common.domain.NameValueList;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ManagerService {

    private final BaseStore<Manager> managerStore;

    public String registerManager(ManagerDto managerDto) {

        return managerStore.create(managerDto.toDomain());
    }

    public void modifyManager(String id, NameValueList nameValues) {
        Manager manager = managerStore.findById(id);
        manager.modifyValues(nameValues);
        managerStore.update(manager);
    }

    public void removeManager(String id) {

        managerStore.delete(id);
    }

    public Manager findManager(String id) {

        return managerStore.findById(id);
    }

    public List<Manager> findAllManager() {

        return managerStore.findAll();
    }
}
