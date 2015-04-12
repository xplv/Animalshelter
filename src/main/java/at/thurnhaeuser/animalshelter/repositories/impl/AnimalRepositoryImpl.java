package at.thurnhaeuser.animalshelter.repositories.impl;

import at.thurnhaeuser.animalshelter.model.Animal;
import at.thurnhaeuser.animalshelter.model.Keeper;
import at.thurnhaeuser.animalshelter.model.QAnimal;
import at.thurnhaeuser.animalshelter.repositories.AnimalRepostitoryCustom;
import com.mysema.query.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by yanik on 4/11/15.
 */
public class AnimalRepositoryImpl implements AnimalRepostitoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Animal> findByKeeper(Keeper keeper) {
        JPAQuery query = new JPAQuery(entityManager);
        QAnimal animal = QAnimal.animal;

        query.from(animal).
                where(animal.keeper.eq(keeper)).
                orderBy(animal.name.asc());

        return query.list(animal);
    }

    @Override
    public List<Animal> findBySpecies(Animal.AnimalSpecies species){
        JPAQuery query = new JPAQuery(entityManager);
        QAnimal animal = QAnimal.animal;

        query.from(animal).
                where(animal.species.eq(species)).
                orderBy(animal.name.asc());
        return query.list(animal);
    }

    @Override
    public List<Animal> findAllMeerschweinchenFromKeeper(Keeper keeper){
        JPAQuery query = new JPAQuery(entityManager);
        QAnimal animal = QAnimal.animal;

        query.from(animal).
                where(animal.species.eq(Animal.AnimalSpecies.Meerschweinchen)).
                where(animal.keeper.eq(keeper)).
                orderBy(animal.name.asc());
        return query.list(animal);
    }
}
