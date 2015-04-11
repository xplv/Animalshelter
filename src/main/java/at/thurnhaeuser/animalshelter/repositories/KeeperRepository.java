package at.thurnhaeuser.animalshelter.repositories;

import at.thurnhaeuser.animalshelter.model.Keeper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by philip on 11.04.2015.
 */
@Repository
public interface KeeperRepository extends CrudRepository<Keeper, Long> {

}
