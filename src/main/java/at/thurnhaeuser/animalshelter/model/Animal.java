package at.thurnhaeuser.animalshelter.model;

import at.thurnhaeuser.animalshelter.LocalDatePersistenceConverter;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) @Setter
    private Compound compound;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) @Setter
    private Keeper keeper;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) @Setter
    private Collection<Toy> toy = new ArrayList<>();

    public Animal(AnimalSpecies species, String name, LocalDate birthDate,Keeper keeper,Compound compound) {
        super();
        this.species = species;
        this.name = name;
        this.birthDate = birthDate;
        this.keeper = keeper;
        this.compound = compound;
    }

    public Compound getCompound() {
        return compound;
    }

    public Collection<Toy> getToy() {
        return toy;
    }

    public Keeper getKeeper() {
        return keeper;
    }
}