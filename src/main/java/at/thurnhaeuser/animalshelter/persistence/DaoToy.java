package at.thurnhaeuser.animalshelter.persistence;

import at.thurnhaeuser.animalshelter.model.Toy;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by philip on 11.04.2015.
 */
public class DaoToy implements Dao<Toy> {
    private EntityManager entityManager;

    public DaoToy(EntityManager entityManager){this.entityManager=entityManager;}

    @Override
    public Toy persist(Toy entity) {
        entityManager.persist(entity); //INSERT eines Toy Datensatzes
        return entity;
    }

    @Override
    public Toy findById(Long id) {
        return entityManager.find(Toy.class, id);
    }

    @Override
    public List<Toy> findAll() {
        Query query = entityManager.createQuery("SELECT t from Toy t", Toy.class);
        return query.getResultList();
    }
}
