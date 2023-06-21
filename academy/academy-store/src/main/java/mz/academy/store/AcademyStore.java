package mz.academy.store;

import mz.academy.domain.entity.Academy;

import java.util.List;

public interface AcademyStore {
    //
    String create(Academy academy);
    void update(Academy academy);
    void delete(String id);
    Academy findAcademy(String id);
    List<Academy> findAll();
}
