/*
 * Copyright (C) 2019 Intel Corporation
 * SPDX-License-Identifier: BSD-3-Clause
 */
package com.intel.mtwilson.core.common.model;

/**
 *
 * @author hmgowda
 */
public enum SoftwareFlavorPrefix {
    DEFAULT_APPLICATION_FLAVOR_PREFIX("ISecL_Default_Application_Flavor_v"),
    DEFAULT_WORKLOAD_FLAVOR_PREFIX("ISecL_Default_Workload_Flavor_v");

    private String value;

    SoftwareFlavorPrefix(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
