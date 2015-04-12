package repositories;

import at.thurnhaeuser.animalshelter.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Created by yanik on 4/12/15.
 */
@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class AnimalRepositoryTest  extends AbstractJUnit4SpringContextTests {
    @Autowired
    private AnimalRepository animalRepo;

}
