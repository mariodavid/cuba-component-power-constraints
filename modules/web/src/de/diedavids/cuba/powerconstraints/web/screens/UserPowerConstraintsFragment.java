package de.diedavids.cuba.powerconstraints.web.screens;

import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.powerconstraints.entity.UserPowerConstraint;

import javax.inject.Inject;

@UiController("ddcpc_UserPowerConstraintsFragment")
@UiDescriptor("user-power-constraints.fragment.xml")
public class UserPowerConstraintsFragment extends ScreenFragment {

    @Inject
    protected GroupTable<UserPowerConstraint> powerConstraintsTable;
    @Inject
    protected CollectionLoader<UserPowerConstraint> powerConstraintsDl;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    protected void onBeforeShow(Screen.BeforeShowEvent event) {
        powerConstraintsDl.load();
    }

    @Subscribe(target = Target.PARENT_CONTROLLER)
    protected void onAfterShow(Screen.AfterShowEvent event) {
        powerConstraintsTable.expandAll();
    }

}