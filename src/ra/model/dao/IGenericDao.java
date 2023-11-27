package ra.model.dao;

import java.util.List;

public interface IGenericDao <T,E>{ // T là kiểu dữ liệu của dối tượng, E là kiểu duwx liệu của ID đối tượng
    List<T> findAll();
    T findById(E id);
    void create(T t);
    void update(T t);
    void deleteById(E id);

}
