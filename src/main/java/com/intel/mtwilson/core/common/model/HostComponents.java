/*
 * Copyright (C) 2019 Intel Corporation
 * SPDX-License-Identifier: BSD-3-Clause
 */
package com.intel.mtwilson.core.common.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hmgowda
 */
public enum HostComponents {
    WLAGENT("wlagent"),
    TAGENT("tagent");

    private String value;

    HostComponents(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    public static List<String> getValues() {
        List<String>  hostComponents = new ArrayList<>();
        for(HostComponents hostComponent: values()) {
            hostComponents.add(hostComponent.getValue());
        }
        return hostComponents;
    }
}
