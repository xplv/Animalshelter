package at.thurnhaeuser.animalshelter.repositories;

import at.thurnhaeuser.animalshelter.model.Animal;
import at.thurnhaeuser.animalshelter.model.Keeper;

import java.util.List;

/**
 * Created by yanik on 4/11/15.
 */
public interface AnimalRepostitoryCustom  {
    List<Animal> findWithQueryDsl(Keeper keeper);
}
