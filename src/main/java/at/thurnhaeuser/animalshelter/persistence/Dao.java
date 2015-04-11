package at.thurnhaeuser.animalshelter.persistence;

import at.thurnhaeuser.animalshelter.model.BaseEntity;

import java.util.List;

/**
 * Created by philip on 10.04.2015.
 */
public interface Dao<T extends BaseEntity> {

    T persist(T entity);
    T findById(Long id);
    List<T> findAll();


}
