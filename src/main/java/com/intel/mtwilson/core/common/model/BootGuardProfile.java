/*
 * Copyright (C) 2019 Intel Corporation
 * SPDX-License-Identifier: BSD-3-Clause
 */
package com.intel.mtwilson.core.common.model;

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
