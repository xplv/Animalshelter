package at.thurnhaeuser.animalshelter.servicespring;

import at.thurnhaeuser.animalshelter.model.Animal;
import at.thurnhaeuser.animalshelter.model.Compound;
import at.thurnhaeuser.animalshelter.model.Keeper;
import at.thurnhaeuser.animalshelter.repositories.AnimalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


/**
 * Created by yanik on 4/12/15.
 */
@Transactional
@Service
public class SpringSampleService {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AnimalRepository animalRepo;

    public void useCaseCreate(String animalName) {
        Keeper k1 = new Keeper("Max","Muster", LocalDate.of(1996,01,23),LocalDate.now());
        Compound c1 = new Compound(100,10);

        Animal a1 = new Animal(Animal.AnimalSpecies.Meerschweinchen,animalName,LocalDate.now(),k1,c1);
        animalRepo.save(a1);
    }

    public void useCaseA() {
        logger.info("Executing use case A");
        useCaseCreate("Fluffy");
    }
}
