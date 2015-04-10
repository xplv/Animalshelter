package at.thurnhaeuser.pflegeheim.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.ArrayList;

/**
 * Created by yanik on 4/10/15.
 */
public class Compound extends BaseEntity{
    @Getter @Setter
    private double sizeInSqm;
    @Getter @Setter
    private int maxAnimals;
    @OneToMany @Getter @Setter
    private ArrayList<Animal> animals;
}
