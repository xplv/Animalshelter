package at.thurnhaeuser.animalshelter.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yanik on 4/10/15.
 */
@Entity
@Table(name="compound")
public class Compound extends BaseEntity{
    @Getter @Setter
    private double sizeInSqm;
    @Getter @Setter
    private int maxAnimals;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compound", fetch = FetchType.EAGER)
    private ArrayList<Animal> animals;

    public Compound() {
        super();
    }


    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(animals);
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        if(animal.getCompound() != this){
            animal.setCompound(this);
        }
    }


}
