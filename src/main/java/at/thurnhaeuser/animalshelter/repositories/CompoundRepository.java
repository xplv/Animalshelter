package at.thurnhaeuser.animalshelter.repositories;

import at.thurnhaeuser.animalshelter.model.Compound;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by philip on 11.04.2015.
 */
@Repository
public interface CompoundRepository extends CrudRepository<Compound, Long> {

}
