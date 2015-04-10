package at.thurnhaeuser.animalshelter.persistence;

import at.thurnhaeuser.animalshelter.model.Animal;
import at.thurnhaeuser.animalshelter.persistence.Dao;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by philip on 10.04.2015.
 */
public class DaoAnimal implements Dao<Animal> {
    private EntityManager entityManager;

    public DaoAnimal(EntityManager entityManager){this.entityManager=entityManager;}

    @Override
    public Animal persist(Animal entity) {
        return null;
    }

    @Override
    public Animal findById(int id) {
        return null;
    }

    @Override
    public List<Animal> findAll() {
        return null;
    }
}
