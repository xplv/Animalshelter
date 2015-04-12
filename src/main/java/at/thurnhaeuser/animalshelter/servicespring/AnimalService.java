package at.thurnhaeuser.animalshelter.servicespring;

import at.thurnhaeuser.animalshelter.model.Animal;
import at.thurnhaeuser.animalshelter.repositories.AnimalRepository;
import domainmodel.Project;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProjectRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by joachim on 24/02/15.
 */
@Transactional
@Service
public class AnimalService {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AnimalRepository animalRepo;

    public Collection<AnimalOverviewDto> findAllAnimals() {
        ArrayList<AnimalOverviewDto> animals = new ArrayList<>();
        for (Animal animal : animalRepo.findAll()) {
            animals.add(AnimalOverviewDto.from(animal));
        }
        return animals;
    }

    public AnimalOverviewDto insertAnimal(AnimalOverviewDto animalOverviewDto) {
        Animal animal = new Animal(animalOverviewDto.getSpecies(), animalOverviewDto.getName(), animalOverviewDto.getBirthDate());
        animalRepo.save(animal);
        return AnimalOverviewDto.from(animal);
    }

    public AnimalOverviewDto findByExternalReference(String externalReference) {
        List<Animal> animals = animalRepo.findByExternalReference(externalReference);
        AnimalOverviewDto animalOverviewDto = null;
        for (Animal animal : animals) {
            animalOverviewDto = AnimalOverviewDto.from(animal);
        }
        return animalOverviewDto;
    }

    public static class AnimalOverviewDto {
        @Getter @Setter
        private String externalReference;

        @Getter @Setter
        private Animal.AnimalSpecies species;

        @Getter @Setter
        private String name;

        @Getter @Setter
        private LocalDate birthDate;

        @Getter @Setter
        private String keeperName;

        @Getter @Setter
        private Integer compoundId;

        @Getter @Setter
        private Integer numberOfToys;

        public static AnimalOverviewDto from(Animal animal) {
            AnimalOverviewDto dto = new AnimalOverviewDto();
            dto.setExternalReference(animal.getExternalReference());
            dto.setSpecies(animal.getSpecies());
            dto.setName(animal.getName());
            dto.setBirthDate(animal.getBirthDate());
            dto.setKeeperName(animal.getKeeper().getLastName());
            dto.setCompoundId(animal.getCompound().getId());
            dto.setNumberOfToys(animal.getToys().size());
            return dto;
        }
    }
}
