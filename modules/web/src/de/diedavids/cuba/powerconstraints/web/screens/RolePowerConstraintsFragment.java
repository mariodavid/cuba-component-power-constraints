package de.diedavids.cuba.powerconstraints.web.screens;

import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.powerconstraints.entity.RolePowerConstraint;

import javax.inject.Inject;

@UiController("ddcpc_RolePowerConstraintsFragment")
@UiDescriptor("role-power-constraints.fragment.xml")
public class RolePowerConstraintsFragment extends ScreenFragment {

    @Inject
    protected GroupTable<RolePowerConstraint> powerConstraintsTable;
    @Inject
    protected CollectionLoader<RolePowerConstraint> powerConstraintsDl;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    protected void onBeforeShow(Screen.BeforeShowEvent event) {
        powerConstraintsDl.load();
    }

    @Subscribe(target = Target.PARENT_CONTROLLER)
    protected void onAfterShow(Screen.AfterShowEvent event) {
        powerConstraintsTable.expandAll();
    }



}