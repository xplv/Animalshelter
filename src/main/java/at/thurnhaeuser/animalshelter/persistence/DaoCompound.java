package at.thurnhaeuser.animalshelter.persistence;

import at.thurnhaeuser.animalshelter.model.Compound;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by philip on 10.04.2015.
 */
public class DaoCompound implements Dao<Compound> {
    private EntityManager entityManager;

    public DaoCompound(EntityManager entityManager){this.entityManager=entityManager;}

    @Override
    public Compound persist(Compound entity) {
        entityManager.persist(entity); //INSERT eines Compound Datensatzes
        return entity;
    }

    @Override
    public Compound findById(int id) {
        return entityManager.find(Compound.class, id);
    }

    @Override
    public List<Compound> findAll() {
        Query query = entityManager.createQuery("SELECT c from Compound", Compound.class);
        return query.getResultList();
    }
}
