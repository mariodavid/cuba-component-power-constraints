package de.diedavids.cuba.powerconstraints.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.security.entity.Constraint;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamePattern("%s|name")
@Table(name = "DDCPC_POWER_CONSTRAINT")
@Entity(name = "ddcpc_PowerConstraint")
public class PowerConstraint extends StandardEntity {
    private static final long serialVersionUID = 4834976880351456227L;

    @Column(name = "TYPE_", nullable = false)
    protected String type;

    @Column(name = "NAME")
    protected String name;

    @Lob
    @Column(name = "DESCRIPTION")
    protected String description;

    @NotNull
    @Column(name = "ACTIVE", nullable = false)
    protected Boolean active = false;

    @Composition
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONSTRAINT_ID")
    protected Constraint constraint;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public PowerConstraintType getType() {
        return type == null ? null : PowerConstraintType.fromId(type);
    }

    public void setType(PowerConstraintType type) {
        this.type = type == null ? null : type.getId();
    }

    public Constraint getConstraint() {
        return constraint;
    }

    public void setConstraint(Constraint constraint) {
        this.constraint = constraint;
    }


    @PostConstruct
    public void postConstruct() {
        if (active == null) {
            setActive(true);
        }
    }
}