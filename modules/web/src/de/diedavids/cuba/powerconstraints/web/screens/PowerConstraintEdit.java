package de.diedavids.cuba.powerconstraints.web.screens;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.EntityStates;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.app.security.constraint.edit.ConstraintEditor;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.entity.Constraint;
import com.haulmont.cuba.security.entity.Group;
import de.diedavids.cuba.powerconstraints.entity.PowerConstraint;

import javax.inject.Inject;
import java.util.UUID;

public class PowerConstraintEdit<T extends PowerConstraint> extends StandardEditor<T> {

    private static final String POWER_CONSTRAINT_ROLE_ID = "164c0b25-ec96-37d2-03e1-86434f5f1815";

    @Inject
    protected ScreenBuilders screenBuilders;
    @Inject
    protected DataManager dataManager;

    @Inject
    protected EntityStates entityStates;
    @Inject
    protected Notifications notifications;
    @Inject
    protected MessageBundle messageBundle;


    @Subscribe
    protected void onInitEntity(InitEntityEvent<T> event) {
        Constraint constraint = dataManager.create(Constraint.class);
        constraint.setGroup(powerConstraintsGroup());
        event.getEntity().setConstraint(constraint);
    }

    private Group powerConstraintsGroup() {
        return dataManager.load(Group.class)
                .id(UUID.fromString(POWER_CONSTRAINT_ROLE_ID))
                .one();
    }

    private void showConstraintEditor() {
        ConstraintEditor editor = (ConstraintEditor) screenBuilders.editor(Constraint.class, this)
                .editEntity(getEditedEntity().getConstraint())
                .withOpenMode(OpenMode.DIALOG)
                .build();

        editor.addAfterCloseListener(afterCloseEvent -> {
            if (afterCloseEvent.closedWith(StandardOutcome.COMMIT)) {
                Constraint persistedConstraint = editor.getEditedEntity();
                getEditedEntity().setConstraint(persistedConstraint);
                notifications.create(Notifications.NotificationType.TRAY)
                        .withCaption(messageBundle.getMessage("constraintSaved"))
                        .show();
            }
        });

        editor.show();
    }

    @Subscribe
    protected void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        if (entityStates.isNew(getEditedEntity().getConstraint())) {
            getEditedEntity().setConstraint(null);
        }
    }


    @Subscribe("constraintField")
    protected void onConstraintFieldClick(Button.ClickEvent event) {
        showConstraintEditor();
    }


}
