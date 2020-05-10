package de.diedavids.cuba.powerconstraints.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum PowerConstraintType implements EnumClass<String> {

    ROLE("ROLE"),
    USER("USER");

    private String id;

    PowerConstraintType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static PowerConstraintType fromId(String id) {
        for (PowerConstraintType at : PowerConstraintType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}