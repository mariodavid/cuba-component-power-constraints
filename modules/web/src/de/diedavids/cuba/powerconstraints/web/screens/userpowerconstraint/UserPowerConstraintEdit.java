package de.diedavids.cuba.powerconstraints.web.screens.userpowerconstraint;

import com.haulmont.cuba.gui.screen.EditedEntityContainer;
import com.haulmont.cuba.gui.screen.LoadDataBeforeShow;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import de.diedavids.cuba.powerconstraints.entity.RolePowerConstraint;
import de.diedavids.cuba.powerconstraints.entity.UserPowerConstraint;
import de.diedavids.cuba.powerconstraints.web.screens.PowerConstraintEdit;

@UiController("ddcpc_UserPowerConstraint.edit")
@UiDescriptor("user-power-constraint-edit.xml")
@EditedEntityContainer("userPowerConstraintDc")
@LoadDataBeforeShow
public class UserPowerConstraintEdit extends PowerConstraintEdit<UserPowerConstraint> {


}