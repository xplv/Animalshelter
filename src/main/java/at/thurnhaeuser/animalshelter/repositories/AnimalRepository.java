package at.thurnhaeuser.animalshelter.repositories;

import at.thurnhaeuser.animalshelter.model.Animal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by yanik on 4/11/15.
 */
public interface AnimalRepository  extends CrudRepository<Animal, Long>, AnimalRepostitoryCustom {
    List<Animal> findByExternalReference(String externalReference);

    List<Animal> findByName(String name);

}
