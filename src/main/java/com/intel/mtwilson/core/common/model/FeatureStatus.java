package com.intel.mtwilson.core.common.model;

/**
 * The FeatureStatus enum represents the status of hardware feature.
 * If FeatureStatus is not supported, status will be UNSUPPORTED.
 * If FeatureStatus is supported, status can be either of ENABLED or DISABLED,
 * depending on whether FeatureStatus is enabled or disabled.
 *
 * @author ddhawale
 */
public enum FeatureStatus {
    DISABLED("DISABLED"),
    ENABLED("ENABLED"),
    UNSUPPORTED("UNSUPPORTED");

    private String value;

    FeatureStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
