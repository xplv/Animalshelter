package at.thurnhaeuser.animalshelter.model;

import javax.persistence.*;
import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.StandardToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by yanik on 4/10/15.
 */

@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    protected BaseEntity() {
    }

    protected BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }
        if (getId() != null)
            return getId().equals(((BaseEntity) obj).getId());
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        if (getId() != null)
            return getId().hashCode();
        return super.hashCode();
    }

    @Override
    public String toString() {
        return getId()+"";
    }
}
