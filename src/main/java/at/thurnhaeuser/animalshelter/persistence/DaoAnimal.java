package at.thurnhaeuser.animalshelter.persistence;

import at.thurnhaeuser.animalshelter.model.Animal;

import javax.persistence.EntityManager;

/**
 * Created by philip on 10.04.2015.
 */
public class DaoAnimal implements Dao<Animal> {
    private EntityManager entityManager;
}
