package mz.academy.store;

import java.util.List;

public interface DefaultStore<T> {
    //
    String create(T academy);
    void update(T academy);
    void delete(String id);
    T findAcademy(String id);
    List<T> findAll();
}
