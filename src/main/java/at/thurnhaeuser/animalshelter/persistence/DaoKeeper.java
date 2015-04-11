package at.thurnhaeuser.animalshelter.persistence;

import at.thurnhaeuser.animalshelter.model.Keeper;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by philip on 10.04.2015.
 */
public class DaoKeeper implements Dao<Keeper> {
    private EntityManager entityManager;

    public DaoKeeper(EntityManager entityManager){this.entityManager=entityManager;}

    @Override
    public Keeper persist(Keeper entity) {
        entityManager.persist(entity);  //INSERT eines Keeper Datensatzes
        return entity;
    }

    @Override
    public Keeper findById(int id) {
        return entityManager.find(Keeper.class, id);
    }

    @Override
    public List<Keeper> findAll() {
        Query query = entityManager.createQuery("SELECT k from Kepper k", Keeper.class);
        return query.getResultList();
    }

}
