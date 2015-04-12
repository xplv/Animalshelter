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


    private AnimalSpecies species;

    private String name;
    @Convert(converter = LocalDatePersistenceConverter.class)

    private LocalDate birthDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Compound compound;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Keeper keeper;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

    public Animal(AnimalSpecies species, String name, LocalDate birthDate) {
        super();
        this.externalReference = UUID.randomUUID().toString();
        this.species = species;
        this.name = name;
        this.birthDate = birthDate;
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

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public void setSpecies(AnimalSpecies species) {
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

    public void setCompound(Compound compound) {
        this.compound = compound;
    }

    public void setKeeper(Keeper keeper) {
        this.keeper = keeper;
    }

    public void setToys(Collection<Toy> toys) {
        this.toys = toys;
    }
}