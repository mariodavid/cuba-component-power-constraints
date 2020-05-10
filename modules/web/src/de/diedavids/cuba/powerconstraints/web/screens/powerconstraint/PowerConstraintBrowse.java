package de.diedavids.cuba.powerconstraints.web.screens.powerconstraint;

import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.powerconstraints.entity.PowerConstraint;

@UiController("ddcpc_PowerConstraint.browse")
@UiDescriptor("power-constraint-browse.xml")
@LoadDataBeforeShow
public class PowerConstraintBrowse extends StandardLookup<PowerConstraint> {
}