package at.thurnhaeuser.animalshelter.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
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


    public Compound() {
        super();
    }

    public Compound(double sizeInSqm, int maxAnimals) {
        this.sizeInSqm = sizeInSqm;
        this.maxAnimals = maxAnimals;
    }
}
