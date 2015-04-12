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

    private String firstName;

    private String lastName;
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate birthDate;
    @Convert(converter = LocalDatePersistenceConverter.class)
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getEmployedSince() {
        return employedSince;
    }

    public void setEmployedSince(LocalDate employedSince) {
        this.employedSince = employedSince;
    }
}
