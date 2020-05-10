package de.diedavids.cuba.powerconstraints.entity;

import com.haulmont.cuba.security.entity.Role;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "ddcpc_RolePowerConstraint")
public class RolePowerConstraint extends PowerConstraint {
    private static final long serialVersionUID = 7682858099369812069L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID")
    protected Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @PostConstruct
    public void postConstruct() {
        setType(PowerConstraintType.ROLE);
    }
}