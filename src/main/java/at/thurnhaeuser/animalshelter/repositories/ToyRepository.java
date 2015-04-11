package at.thurnhaeuser.animalshelter.repositories;

import at.thurnhaeuser.animalshelter.model.Toy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yanik on 4/11/15.
 */
@Repository
public interface ToyRepository extends CrudRepository<Toy, Long> {

}
