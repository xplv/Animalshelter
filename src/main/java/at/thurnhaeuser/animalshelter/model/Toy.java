package at.thurnhaeuser.animalshelter.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by philip on 11.04.2015.
 */
@Entity
@Table(name="toy")
public class Toy extends BaseEntity {
    public static enum Material{wood,plastic,rubber};
    public static enum Color{red,green,brown};

    @Getter @Setter
    private Material mat;

    @Getter @Setter
    private Color col;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private double sizeCM;

    protected Toy(){super();}
    public Toy(Material mat, Color col, String name, double sizeCM){
        super();
        this.mat = mat;
        this.col = col;
        this.name = name;
        this.sizeCM = sizeCM;
    }


}
