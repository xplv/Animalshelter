package at.thurnhaeuser.animalshelter.model;

import at.thurnhaeuser.animalshelter.LocalDatePersistenceConverter;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by yanik on 4/10/15.
 */
@Entity
@Table(name = "animal")
public class Animal extends BaseEntity {
    public static enum AnimalSpecies {Hund, Katze, Meerschweinchen}

    @Getter
    @Setter
    private AnimalSpecies species;
    @Getter
    @Setter
    private String name;
    @Convert(converter = LocalDatePersistenceConverter.class)
    @Getter
    @Setter
    private LocalDate birthDate;

    public Animal(AnimalSpecies species, String name, LocalDate birthDate) {
        super();
        this.species = species;
        this.name = name;
        this.birthDate = birthDate;
    }
}