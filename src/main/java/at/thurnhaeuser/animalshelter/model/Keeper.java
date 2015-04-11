package at.thurnhaeuser.animalshelter.model;

import at.thurnhaeuser.animalshelter.LocalDatePersistenceConverter;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by yanik on 4/10/15.
 */
@Entity
@Table(name = "keeper")
public class Keeper extends BaseEntity{
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String lastName;
    @Convert(converter = LocalDatePersistenceConverter.class) @Getter @Setter
    private LocalDate birthDate;
    @Convert(converter = LocalDatePersistenceConverter.class) @Getter @Setter
    private LocalDate employedSince;



    public Keeper() {
        super();
    }

    public Keeper( String firstName, String lastName, LocalDate birthDate, LocalDate employedSince) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.employedSince = employedSince;
    }
}
