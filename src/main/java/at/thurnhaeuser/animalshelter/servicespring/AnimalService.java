package at.thurnhaeuser.animalshelter.servicespring;

import at.thurnhaeuser.animalshelter.model.Animal;
import at.thurnhaeuser.animalshelter.repositories.AnimalRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        private String externalReference;

        private Animal.AnimalSpecies species;

        private String name;

        private LocalDate birthDate;

        private String keeperName;

        private Long compoundId;

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

        public String getExternalReference() {
            return externalReference;
        }

        public void setExternalReference(String externalReference) {
            this.externalReference = externalReference;
        }

        public Animal.AnimalSpecies getSpecies() {
            return species;
        }

        public void setSpecies(Animal.AnimalSpecies species) {
            this.species = species;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
        }

        public String getKeeperName() {
            return keeperName;
        }

        public void setKeeperName(String keeperName) {
            this.keeperName = keeperName;
        }

        public Long getCompoundId() {
            return compoundId;
        }

        public void setCompoundId(Long compoundId) {
            this.compoundId = compoundId;
        }

        public Integer getNumberOfToys() {
            return numberOfToys;
        }

        public void setNumberOfToys(Integer numberOfToys) {
            this.numberOfToys = numberOfToys;
        }
    }
}
