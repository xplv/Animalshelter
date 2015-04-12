package at.thurnhaeuser.animalshelter.model;

import at.thurnhaeuser.animalshelter.LocalDatePersistenceConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

/**
 * Created by yanik on 4/10/15.
 */
@Entity
@Table(name = "animal")
public class Animal extends BaseEntity {
    public AnimalSpecies getSpecies() {
        return species;
    }

    public static enum AnimalSpecies {Hund, Katze, Meerschweinchen}

    @NotNull @Getter
    @Column(nullable = false)
    private String externalReference;

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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) @Getter
    private Collection<Toy> toys = new ArrayList<>();

    protected Animal(){
        super();
    }
    public Animal(AnimalSpecies species, String name, LocalDate birthDate,Keeper keeper,Compound compound) {
        super();
        this.externalReference = UUID.randomUUID().toString();
        this.species = species;
        this.name = name;
        this.birthDate = birthDate;
        this.keeper = keeper;
        this.compound = compound;
    }

    public Compound getCompound() {
        return compound;
    }

    public Collection<Toy> getToys() {
        return toys;
    }

    public Keeper getKeeper() {
        return keeper;
    }

    public void addToy(Toy t){
        toys.add(t);
    }
}