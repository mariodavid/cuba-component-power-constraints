package de.diedavids.cuba.powerconstraints.core;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.security.app.group.AccessConstraintsBuilder;
import com.haulmont.cuba.security.auth.events.UserLoggedInEvent;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.security.global.UserSession;
import de.diedavids.cuba.powerconstraints.entity.PowerConstraint;
import de.diedavids.cuba.powerconstraints.entity.RolePowerConstraint;
import de.diedavids.cuba.powerconstraints.entity.UserPowerConstraint;
import org.slf4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

@Component(PowerConstraintsInitialization.NAME)
public class PowerConstraintsInitialization {
    public static final String NAME = "ddcpc_PowerConstraintsInitialization";

    @Inject
    protected Metadata metadata;

    @Inject
    private Logger log;

    @Inject
    protected DataManager dataManager;

    @EventListener
    protected void onUserLoggedIn(UserLoggedInEvent event) {
        UserSession session = event.getUserSession();

        session.setConstraints(
                customConstraints(session)
                        .join(session.getConstraints())
                        .build()
        );
        log.info("Logged in user {}", session.getUser().getName());
    }

    private AccessConstraintsBuilder customConstraints(UserSession session) {

        AccessConstraintsBuilder builder = AccessConstraintsBuilder.create();

        loadUserConstraints(session.getUser())
                .forEach(constraint -> addPowerConstraint(builder, constraint));
        loadRoleConstraints(session.getRoles())
                .forEach(constraint -> addPowerConstraint(builder, constraint));

        return builder;
    }

    private void addPowerConstraint(AccessConstraintsBuilder customConstraintsBuilder, PowerConstraint powerConstraint) {
        String entityName = powerConstraint.getConstraint().getEntityName();
        Class<? extends Entity> entityJavaClass = metadata.getClass(entityName).getJavaClass();
        customConstraintsBuilder.withJpql(entityJavaClass, powerConstraint.getConstraint().getWhereClause());
    }

    private List<UserPowerConstraint> loadUserConstraints(User user) {
        return dataManager.load(UserPowerConstraint.class)
                .query("e.user = ?1", user)
                .view("powerConstraint-view")
                .list();
    }

    private List<RolePowerConstraint> loadRoleConstraints(Collection<String> roleNames) {
        return dataManager.load(RolePowerConstraint.class)
                .query("e.role.name in ?1", roleNames)
                .view("powerConstraint-view")
                .list();
    }
}