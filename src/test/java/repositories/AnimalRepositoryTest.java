package repositories;

import at.thurnhaeuser.animalshelter.model.Animal;
import at.thurnhaeuser.animalshelter.model.Compound;
import at.thurnhaeuser.animalshelter.model.Keeper;
import at.thurnhaeuser.animalshelter.repositories.AnimalRepository;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.time.LocalDate;

/**
 * Created by yanik on 4/12/15.
 */
@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class AnimalRepositoryTest  extends AbstractJUnit4SpringContextTests {
    @Autowired
    private AnimalRepository animalRepo;

    private Keeper keeper;

    @Before
    public void setup() {
        // remove existing data
        animalRepo.deleteAll();

        // create test data
        keeper = new Keeper("Max","Muster",LocalDate.now(),LocalDate.now());
        Compound compound = new Compound(100,10);
        Animal animal = new Animal("Wurzel", LocalDate.of(2014, 9, 01), LocalDate.of(2015, 6, 30));
        project.setRootProjectFolder(projectFolder);
        projectRepository.save(project);
    }


}
