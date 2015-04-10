package at.thurnhaeuser.animalshelter.persistence;

import at.thurnhaeuser.animalshelter.model.Animal;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by philip on 10.04.2015.
 */
public class DaoAnimal implements Dao<Animal> {
    private EntityManager entityManager;

    public DaoAnimal(EntityManager entityManager){this.entityManager=entityManager;}

    @Override
    public Animal persist(Animal entity) {
        entityManager.persist(entity); //INSERT eines Animal Datensatzes
        return entity;
    }

    @Override
    public Animal findById(int id) {
        return entityManager.find(Animal.class, id);
    }

    @Override
    public List<Animal> findAll() {
        Query query = entityManager.createQuery("SELECT a fom Animal a", Animal.class);
        return query.getResultList();
    }

}
