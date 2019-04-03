package com.intel.mtwilson.core.common.model;

/**
 * The ComponentStatus enum represents the status of component.
 * If ComponentStatus is not supported, status will be UNSUPPORTED.
 * If ComponentStatus is supported, status can be either of INSTALLED or NOT_INSTALLED,
 * depending on whether ComponentStatus is installed or not.
 *
 * @author ddhawale
 */
public enum ComponentStatus {
    INSTALLED("INSTALLED"),
    NOT_INSTALLED("NOT_INSTALLED"),
    UNSUPPORTED("UNSUPPORTED");

    private String value;

    ComponentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
