package at.thurnhaeuser.pflegeheim.model;

import at.thurnhaeuser.pflegeheim.LocalDatePersistenceConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by yanik on 4/10/15.
 */
@Table(name = "animal")
public class Animal extends BaseEntity{
    public static enum AnimalSpecies{Hund,Katze,Meerschweinchen}

    @NotNull @Getter @Setter
    private AnimalSpecies species;
    @Getter @Setter
    private String name;
    @NotNull @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Keeper keeper;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) @Getter @Setter
    private Animal bestFriend;
    @NotNull @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) @JoinColumn(nullable = false)
    private Compound compound;
    @Convert(converter = LocalDatePersistenceConverter.class) @Getter @Setter
    private LocalDate birthDate;

    public Animal(Long id, AnimalSpecies species, String name, Keeper keeper, Animal bestFriend, Compound compound, LocalDate birthDate) {
        super(id);
        this.species = species;
        this.name = name;
        this.keeper = keeper;
        this.bestFriend = bestFriend;
        this.compound = compound;
        this.birthDate = birthDate;
    }

    public  Animal(){
        super();
    }

    public Keeper getKeeper() {
        return keeper;
    }

    public Compound getCompound() {
        return compound;
    }

    public void setKeeper(Keeper keeper) {
        this.keeper = keeper;
    }

    public void setCompound(Compound compound) {
        this.compound = compound;
    }
}
