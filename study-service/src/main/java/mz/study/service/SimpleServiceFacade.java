package mz.study.service;

import java.util.List;

public interface SimpleServiceFacade {


    Object find(long seq);

    List<Object> findAll();

    Object save(Object entity);

    void delete(long seq);
}
