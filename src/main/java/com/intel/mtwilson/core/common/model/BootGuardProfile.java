package com.intel.mtwilson.core.common.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ddhawal
 */
public enum BootGuardProfile {
    BTGP4("BTGP4", "51"),
    BTGP5("BTGP5", "7D");

    private String name;
    private String value;

    BootGuardProfile(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
