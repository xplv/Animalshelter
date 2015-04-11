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

    @NotNull
    @Getter @Setter
    private AnimalSpecies species;
    @Getter @Setter
    private String name;
    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false)
    private Keeper keeper;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Animal bestFriend;
    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false)
    private Compound compound;
    @Convert(converter = LocalDatePersistenceConverter.class)
    @Getter @Setter
    private LocalDate birthDate;

    public Animal(AnimalSpecies species, String name, Keeper keeper, Animal bestFriend, Compound compound, LocalDate birthDate) {
        super();
        this.species = species;
        this.name = name;
        setKeeper(keeper);
        setBestFriend(bestFriend);
        setCompound(compound);
        this.birthDate = birthDate;
    }

    public void setBestFriend(Animal animal) {
        if (animal != null) {
            this.bestFriend = animal;
            if (animal.bestFriend != this) {
                animal.bestFriend = this;
            }
        }
    }

    public void setKeeper(Keeper keeper) {
        this.keeper = keeper;
        if (keeper.getAnimals() != this) {
            keeper.addAnimal(this);
        }
    }

    public void setCompound(Compound compound) {
        this.compound = compound;
        if (compound.getAnimals() != this) {
            compound.addAnimal(this);
        }
    }

    public Keeper getKeeper() {
        return keeper;
    }

    public Animal getBestFriend() {
        return bestFriend;
    }

    public Compound getCompound() {
        return compound;
    }
}