package de.diedavids.cuba.powerconstraints.entity;

import com.haulmont.cuba.security.entity.User;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "ddcpc_UserPowerConstraint")
public class UserPowerConstraint extends PowerConstraint {
    private static final long serialVersionUID = 3339546029879274151L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    protected User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @PostConstruct
    public void postConstruct() {
        setType(PowerConstraintType.USER);
    }
}