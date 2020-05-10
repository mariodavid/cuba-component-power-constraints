package de.diedavids.cuba.powerconstraints.web.screens.rolepowerconstraint;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.EntityStates;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.app.security.constraint.edit.ConstraintEditor;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.entity.Constraint;
import com.haulmont.cuba.security.entity.Group;
import de.diedavids.cuba.powerconstraints.entity.RolePowerConstraint;
import de.diedavids.cuba.powerconstraints.web.screens.PowerConstraintEdit;

import javax.inject.Inject;
import java.util.UUID;

@UiController("ddcpc_RolePowerConstraint.edit")
@UiDescriptor("role-power-constraint-edit.xml")
@EditedEntityContainer("rolePowerConstraintDc")
@LoadDataBeforeShow
public class RolePowerConstraintEdit extends PowerConstraintEdit<RolePowerConstraint> {


}