package at.thurnhaeuser.animalshelter.restmvc;

import at.thurnhaeuser.animalshelter.servicespring.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



import java.util.Collection;

/**
 * Created by philip on 12.04.2015.
 */
@RestController
@RequestMapping("/animals")
public class AnimalRestController {

    @Autowired
    private AnimalService animalService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<AnimalService.AnimalOverviewDto>readAnimals(){
        return animalService.findAllAnimals();
    }

    @RequestMapping(method = RequestMethod.POST)
    @RequestMapping(HttpStatus.CREATED)
    public AnimalService.AnimalOverviewDto insertAnimal(@RequestBody AnimalService.AnimalOverviewDto animalOverviewDto){
        return animalService.insertAnimal(animalOverviewDto);
    }

    @RequestMapping(value = "/{externalReference}", method = RequestMethod.GET)
    public AnimalService.AnimalOverviewDto readOneAnimal(@PathVariable(value = "externalReference")String externalReference){
        return animalService.findByExternalReference(externalReference);
    }
}
